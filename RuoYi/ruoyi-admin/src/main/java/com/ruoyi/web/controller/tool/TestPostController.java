package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestPostController extends BaseController {


    private final static Map<Integer, PostEntity> posts = new LinkedHashMap<Integer, PostEntity>();

    {
        //Integer postId, String postCode, String postName, String postSort, String status
        posts.put(1, new PostEntity(1, "user" , "普通员工" , "6" , "0"));
        posts.put(2, new PostEntity(2, "user" , "普通员工" , "6" , "0"));

    }

    @ApiOperation("获取岗位列表")
    @GetMapping("/list")
    public AjaxResult postList() {
        List<PostEntity> postList = new ArrayList<PostEntity>(posts.values());
        return AjaxResult.success(postList);
    }

    @ApiOperation("获取岗位详细")
    @ApiImplicitParam(name = "postId" , value = "岗位序号" , required = true, dataType = "int" , paramType = "path")
    @GetMapping("/{postId}")
    public AjaxResult getPost(@PathVariable Integer postId) {
        if (!posts.isEmpty() && posts.containsKey(postId)) {
            return AjaxResult.success(posts.get(postId));
        } else {
            return error("岗位不存在");
        }
    }


    @ApiOperation("新增岗位")
    @ApiImplicitParam(name = "postEntity" , value = "新增岗位信息" , dataType = "PostEntity")
    @PostMapping("/increasePost")
    public AjaxResult increasePost(PostEntity post) {
        if (StringUtils.isNull(post) || StringUtils.isNull(post.getPostId())) {
            return error("岗位序号不能为空");
        }
        return AjaxResult.success(posts.put(post.getPostId(), post));
    }

    @ApiOperation("更新岗位")
    @ApiImplicitParam(name = "postEntity" , value = "更新岗位信息" , dataType = "PostEntity")
    @PutMapping("/update")
    public AjaxResult update(PostEntity post) {
        if (StringUtils.isNull(post) || StringUtils.isNull(post.getPostId())) {
            return error("岗位序号不能为空");
        }
        if (posts.isEmpty() || !posts.containsKey(post.getPostId())) {
            return error("岗位不存在");
        }
        posts.remove(post.getPostId());
        return AjaxResult.success(posts.put(post.getPostId(), post));
    }

    @ApiOperation("删除岗位信息")
    @ApiImplicitParam(name = "postId" , value = "岗位序号" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{postId}")
    public AjaxResult delete(@PathVariable Integer postId) {
        if (!posts.isEmpty() && posts.containsKey(postId)) {
            posts.remove(postId);
            return success();
        } else {
            return error("岗位不存在");
        }
    }


}

@ApiModel("岗位实体")
class PostEntity {


    @ApiModelProperty("岗位序号")
    private Integer postId;

    @ApiModelProperty("岗位编码")
    private String postCode;

    @ApiModelProperty("岗位名称")
    private String postName;

    @ApiModelProperty("岗位排序")
    private String postSort;

    @ApiModelProperty("状态")
    private String status;


    public PostEntity(Integer postId, String postCode, String postName, String postSort, String status) {
        this.postId = postId;
        this.postCode = postCode;
        this.postName = postName;
        this.postSort = postSort;
        this.status = status;
    }

    public PostEntity() {
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostSort() {
        return postSort;
    }

    public void setPostSort(String postSort) {
        this.postSort = postSort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}