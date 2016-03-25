package com.wzj.ssm.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wzj.ssm.entity.FileInfo;
import com.wzj.ssm.entity.ResultMessage;
import com.wzj.ssm.util.StringUtil;

/**
 * 
 * 实现如下功能: 1: 支持 session application 对象的存储 2: 返回 json格式, 解决乱码问题 3:
 * 采用拦截器,完成用户登陆的过滤
 * 
 */
@RequestMapping("/fileInfo")
@Controller
// 开启注解扫描机制
public class FileInfoController extends BaseController {

	@RequestMapping("/list")
	public ModelAndView list() {
		try {
			return this.getAutoView();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@RequestMapping("/getAll")
	@ResponseBody
	public Object getList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FileInfo> fileInfoList = fileInfoService.selectAll();
		int total = fileInfoList.size();
		map.put("Rows", fileInfoList);
		map.put("Total", total);
		return map;
	}

	@RequestMapping("/save")
	@ResponseBody
	public Object save(FileInfo fileInfo, @RequestParam("file") CommonsMultipartFile file) {
		// 获得原始文件名
		String fileName = file.getOriginalFilename();
		System.out.println("原始文件名:" + fileName);
		
		String resultMsg = null;
		ResultMessage resultMessage = new ResultMessage();
		Integer fileInfoId = fileInfo.getFileInfoId();
		if (fileInfoId == null || fileInfoId == 0) {
			resultMsg = "添加数据成功";
			fileInfoService.insertSelective(fileInfo);
		} else {
			resultMsg = "更新数据成功";
			fileInfoService.updateByPrimaryKeySelective(fileInfo);
		}
		resultMessage.addMessage(resultMsg).addMessage("fileInfoId", fileInfo.getFileInfoId());
		return resultMessage.getReturnMap();
	}

	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mv = null;
		try {
			String fileInfoIdStr = request.getParameter("fileInfoId");
			String isReadOnly = request.getParameter("isReadOnly");
			Integer fileInfoId = StringUtil.parseIntIsNullGetDef(fileInfoIdStr, 0);
			FileInfo fileInfoDB = fileInfoService.selectByPrimaryKey(fileInfoId);
			mv = getAutoView().addObject("fileInfo", fileInfoDB).addObject("isReadOnly", isReadOnly);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return mv;
	}
	
}
