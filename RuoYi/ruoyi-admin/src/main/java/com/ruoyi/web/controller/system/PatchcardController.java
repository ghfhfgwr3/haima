package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/system/patchcard")
public class PatchcardController extends BaseController {
    private String prefix = "system/patchcard";

    @RequiresPermissions("system:patchcard:view")
    @GetMapping()
    public String patchcard() {
        return prefix + "/patchcard";
    }


}
