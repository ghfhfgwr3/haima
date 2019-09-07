package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * swagger 公告测试方法
 *
 * @author ruoyi
 */
@Api("公告信息管理")
@RestController
@RequestMapping("/test/notice")
public class TestNoticeController extends BaseController {

    private final static Map<Integer, NoticeEntity> notices = new LinkedHashMap<Integer, NoticeEntity>();

    {

        //Integer noticeId, String noticeTitle, String noticeType, String noticeContent, String status
        notices.put(3, new NoticeEntity(3, "你中奖了" , "1" , "公告内容" , "0"));
        notices.put(4, new NoticeEntity(4, "你中奖了" , "2" , "公告内容" , "0"));

    }

    @ApiOperation("获取公告列表")
    @GetMapping("/list")
    public AjaxResult noticeList() {
        List<NoticeEntity> noticeList = new ArrayList<NoticeEntity>(notices.values());
        return AjaxResult.success(noticeList);
    }

    @ApiOperation("获取公告详细")
    @ApiImplicitParam(name = "noticeId" , value = "公告ID" , required = true, dataType = "int" , paramType = "path")
    @GetMapping("/{noticeId}")
    public AjaxResult getNotice(@PathVariable Integer noticeId) {
        if (!notices.isEmpty() && notices.containsKey(noticeId)) {
            return AjaxResult.success(notices.get(noticeId));
        } else {
            return error("公告不存在");
        }
    }

    @ApiOperation("新增公告")
    @ApiImplicitParam(name = "noticeEntity" , value = "新增公告信息" , dataType = "NoticeEntity")
    @PostMapping("/increaseNotice")
    public AjaxResult increaseNotice(NoticeEntity notice) {
        if (StringUtils.isNull(notice) || StringUtils.isNull(notice.getNoticeId())) {
            return error("公告ID不能为空");
        }
        return AjaxResult.success(notices.put(notice.getNoticeId(), notice));
    }

    @ApiOperation("更新公告")
    @ApiImplicitParam(name = "noticeEntity" , value = "更新公告信息" , dataType = "NoticeEntity")
    @PutMapping("/update")
    public AjaxResult updateNotice(NoticeEntity notice) {
        if (StringUtils.isNull(notice) || StringUtils.isNull(notice.getNoticeId())) {
            return error("公告ID不能为空");
        }
        if (notices.isEmpty() || !notices.containsKey(notice.getNoticeId())) {
            return error("公告不存在");
        }
        notices.remove(notice.getNoticeId());
        return AjaxResult.success(notices.put(notice.getNoticeId(), notice));
    }

    @ApiOperation("删除公告信息")
    @ApiImplicitParam(name = "noticeId" , value = "公告ID" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{noticeId}")
    public AjaxResult deleteNotice(@PathVariable Integer noticeId) {
        if (!notices.isEmpty() && notices.containsKey(noticeId)) {
            notices.remove(noticeId);
            return success();
        } else {
            return error("公告不存在");
        }
    }


}


@ApiModel("公告实体")
class NoticeEntity {


    @ApiModelProperty("公告ID")
    private Integer noticeId;

    @ApiModelProperty("公告标题")
    private String noticeTitle;

    @ApiModelProperty("公告类型")
    private String noticeType;

    @ApiModelProperty("公告内容")
    private String noticeContent;

    @ApiModelProperty("公告状态")
    private String status;


    public NoticeEntity(Integer noticeId, String noticeTitle, String noticeType, String noticeContent, String status) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeType = noticeType;
        this.noticeContent = noticeContent;
        this.status = status;
    }

    public NoticeEntity() {
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}