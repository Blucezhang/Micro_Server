package com.own.user.party.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.own.face.party.OrgBean;
import com.own.face.util.Resp;
import com.own.face.util.Util;
import com.own.user.party.dao.LoginUserDao;
import com.own.user.party.dao.OrgDao;
import com.own.user.party.dao.domain.Organization;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/org")
public class OrgController {
	
	@Autowired
	private OrgDao orgDao = null;
	@Autowired
	private LoginUserDao loginUserDao = null;

	@ApiOperation(value = "根据id查询organization信息")
	@GetMapping("/Org")
	public @ResponseBody
	Resp queryOrg(){
		List<Organization> organizations = orgDao.queryOrg();
 		return new Resp(organizations);
 	}

	@ApiOperation(value = "根据id查询organization信息")
	@GetMapping(value = "/Org",params={"Action=All"})
	public @ResponseBody Resp queryAllOrg(){
		List<Organization> organizations = orgDao.queryAllOrg();
 		return new Resp(organizations);
 	}

	@ApiOperation(value = "根据id查询organization信息")
	@GetMapping(value = "/Org/{id}",params = {"Action=Single"})
	public @ResponseBody Resp getOrgSingle(@PathVariable Integer id){
		Organization organization = (Organization) orgDao.getFromId(id);
 		return new Resp(organization);
 	}

	@ApiOperation(value = "根据id查询organization信息")
	@GetMapping(value = "/Org/{id}",params = {"Action=All"})
	public @ResponseBody Resp getOrgAll(@PathVariable Integer id){
		List<Organization> organizations = orgDao.queryChildOrg(id);
 		return new Resp(organizations);
 	}
	
	@ApiOperation(value = "创建organization信息 (创建组织)")
	@PutMapping("/Org")
	public @ResponseBody void createOrg(@RequestBody OrgBean ob){
		Organization organization = new Organization();
		organization.setName(ob.getName());
		organization.setLoginName(ob.getLoginName());
		organization.setLevel(ob.getLevel());
		organization.setPartyTypeId(1);
		organization.setPartyTypeName("组织");
		organization.setPhone(ob.getPhone());
		organization.setEmail(ob.getEmail());
		orgDao.save(organization);
		if(Util.isNullOrEmpty(organization.getOrgId())){
			orgDao.createRelationShipData(organization.getId());
		}
 	}

	@ApiOperation(value = " 创建organization子级信息")
	@PutMapping("/Org/{id}")
	public @ResponseBody void createOrgChild(@PathVariable Integer id,@RequestBody Organization organization){
		organization.setPartyTypeId(2);
		organization.setPartyTypeName("部门");
		orgDao.save(organization);
		orgDao.createChildRelationShip(id,organization.getId());
 	}

	@ApiOperation(value = "根据id修改org信息")
	@PostMapping("/Org/{id}")
	public @ResponseBody void updOrg(@PathVariable Integer id,@RequestBody Organization o){
		Organization organization = (Organization) orgDao.getFromId(id);
		organization.setName(o.getName());
		organization.setLevel(o.getLevel());
		orgDao.save(organization);
 	}
	

	@ApiOperation(value = "根据id删除org信息")
	@DeleteMapping("/Org/{id}")
	public @ResponseBody void deleteOrg(@PathVariable Integer id){
		orgDao.deleteOrg(id);
 	}

}
