package com.minimall.user.controller;

import com.minimall.common.utils.DateUtil;
import com.minimall.common.utils.ResponseUtil;
import com.minimall.db.domain.LitemallUser;
import com.minimall.db.domain.LitemallUserFormid;
import com.minimall.db.service.LitemallUserFormIdService;
import com.minimall.db.service.LitemallUserService;
import com.minimall.common.annotation.LoginUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Date;

@RestController
@RequestMapping("/wx/formid")
@Validated
public class WxUserFormId {
    private final Log logger = LogFactory.getLog(WxUserFormId.class);

    @Autowired
    private LitemallUserService userService;

    @Autowired
    private LitemallUserFormIdService formIdService;

    @GetMapping("create")
    public Object create(@LoginUser Integer userId, @NotNull String formId) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        LitemallUser user = userService.findById(userId);
        LitemallUserFormid userFormid = new LitemallUserFormid();
        userFormid.setOpenid(user.getWeixinOpenid());
        userFormid.setFormid(formId);
        userFormid.setIsprepay(false);
        userFormid.setUseamount(1);
        userFormid.setExpireTime(DateUtil.addDays(new Date(),7));
        formIdService.addUserFormid(userFormid);

        return ResponseUtil.ok();
    }
}
