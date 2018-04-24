package com.jobtong.bean;

import com.alibaba.fastjson.JSONObject;

public class People {

	private String id;
	private String name;
	private String sex;
	private String alias;
	private String email;
	private String mobile;
	private String company_id;
	private String company_name;
	private String company_position;
	private String is_company_admin;
	private String pending_company_id;
	private String sign;
	private String ctime;
	private String resume_percent;
	private String experience;
	private String degree;
	private String photo_url;
	private String introduction;
	private String birth_day;
	private String work_status;
	private String current_city_id;
	private String native_city_id;
	private String expect_city_id;
	private String expect_job_category_id;
	private String expect_min_salary;
	private String expect_max_salary;
	private String blog_url;
	private String sina_weibo_url;
	private String github_url;
	private String zcool_url;
	private String domain_path;
	private String current_city_name;
	private String native_city_name;
	private String expect_city_name;
	private String company;
	private String pending_company;
	private String expect_job_category_name;
	private String is_liked;
	private String download_url;

	public People(JSONObject peopleObj) {
		this.setId(String.valueOf(peopleObj.get("id")));
		this.setName(String.valueOf(peopleObj.get("name")));
		this.setSex(String.valueOf(peopleObj.get("sex")));
		this.setAlias(String.valueOf(peopleObj.get("alias")));
		this.setEmail(String.valueOf(peopleObj.get("email")));
		this.setMobile(String.valueOf(peopleObj.get("mobile")));
		this.setCompany_id(String.valueOf(peopleObj.get("company_id")));
		this.setCompany_name(String.valueOf(peopleObj.get("company_name")));
		this.setCompany_position(String.valueOf(peopleObj.get("company_position")));
		this.setIs_company_admin(String.valueOf(peopleObj.get("is_company_admin")));
		this.setPending_company_id(String.valueOf(peopleObj.get("pending_company_id")));
		this.setSign(String.valueOf(peopleObj.get("sign")));
		this.setCtime(String.valueOf(peopleObj.get("ctime")));
		this.setResume_percent(String.valueOf(peopleObj.get("resume_percent")));
		this.setExperience(String.valueOf(peopleObj.get("experience")));
		this.setDegree(String.valueOf(peopleObj.get("degree")));
		this.setPhoto_url(String.valueOf(peopleObj.get("photo_url")));
		this.setIntroduction(String.valueOf(peopleObj.get("introduction")));
		this.setBirth_day(String.valueOf(peopleObj.get("birth_day")));
		this.setWork_status(String.valueOf(peopleObj.get("work_status")));
		this.setCurrent_city_id(String.valueOf(peopleObj.get("current_city_id")));
		this.setNative_city_id(String.valueOf(peopleObj.get("native_city_id")));
		this.setExpect_city_id(String.valueOf(peopleObj.get("expect_city_id")));
		this.setExpect_job_category_id(String.valueOf(peopleObj.get("expect_job_category_id")));
		this.setExpect_min_salary(String.valueOf(peopleObj.get("expect_min_salary")));
		this.setExpect_max_salary(String.valueOf(peopleObj.get("expect_max_salary")));
		this.setBlog_url(String.valueOf(peopleObj.get("blog_url")));
		this.setSina_weibo_url(String.valueOf(peopleObj.get("sina_weibo_url")));
		this.setGithub_url(String.valueOf(peopleObj.get("github_url")));
		this.setZcool_url(String.valueOf(peopleObj.get("zcool_url")));
		this.setDomain_path(String.valueOf(peopleObj.get("domain_path")));
		this.setCurrent_city_name(String.valueOf(peopleObj.get("current_city_name")));
		this.setNative_city_name(String.valueOf(peopleObj.get("native_city_name")));
		this.setExpect_city_name(String.valueOf(peopleObj.get("expect_city_name")));
		this.setCompany(String.valueOf(peopleObj.get("company")));
		this.setPending_company(String.valueOf(peopleObj.get("pending_company")));
		this.setExpect_job_category_name(String.valueOf(peopleObj.get("expect_job_category_name")));
		this.setIs_liked(String.valueOf(peopleObj.get("is_liked")));
		this.setDownload_url(String.valueOf(peopleObj.get("download_url")));

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_position() {
		return company_position;
	}

	public void setCompany_position(String company_position) {
		this.company_position = company_position;
	}

	public String getIs_company_admin() {
		return is_company_admin;
	}

	public void setIs_company_admin(String is_company_admin) {
		this.is_company_admin = is_company_admin;
	}

	public String getPending_company_id() {
		return pending_company_id;
	}

	public void setPending_company_id(String pending_company_id) {
		this.pending_company_id = pending_company_id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getResume_percent() {
		return resume_percent;
	}

	public void setResume_percent(String resume_percent) {
		this.resume_percent = resume_percent;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(String birth_day) {
		this.birth_day = birth_day;
	}

	public String getWork_status() {
		return work_status;
	}

	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}

	public String getCurrent_city_id() {
		return current_city_id;
	}

	public void setCurrent_city_id(String current_city_id) {
		this.current_city_id = current_city_id;
	}

	public String getNative_city_id() {
		return native_city_id;
	}

	public void setNative_city_id(String native_city_id) {
		this.native_city_id = native_city_id;
	}

	public String getExpect_city_id() {
		return expect_city_id;
	}

	public void setExpect_city_id(String expect_city_id) {
		this.expect_city_id = expect_city_id;
	}

	public String getExpect_job_category_id() {
		return expect_job_category_id;
	}

	public void setExpect_job_category_id(String expect_job_category_id) {
		this.expect_job_category_id = expect_job_category_id;
	}

	public String getExpect_min_salary() {
		return expect_min_salary;
	}

	public void setExpect_min_salary(String expect_min_salary) {
		this.expect_min_salary = expect_min_salary;
	}

	public String getExpect_max_salary() {
		return expect_max_salary;
	}

	public void setExpect_max_salary(String expect_max_salary) {
		this.expect_max_salary = expect_max_salary;
	}

	public String getBlog_url() {
		return blog_url;
	}

	public void setBlog_url(String blog_url) {
		this.blog_url = blog_url;
	}

	public String getSina_weibo_url() {
		return sina_weibo_url;
	}

	public void setSina_weibo_url(String sina_weibo_url) {
		this.sina_weibo_url = sina_weibo_url;
	}

	public String getGithub_url() {
		return github_url;
	}

	public void setGithub_url(String github_url) {
		this.github_url = github_url;
	}

	public String getZcool_url() {
		return zcool_url;
	}

	public void setZcool_url(String zcool_url) {
		this.zcool_url = zcool_url;
	}

	public String getDomain_path() {
		return domain_path;
	}

	public void setDomain_path(String domain_path) {
		this.domain_path = domain_path;
	}

	public String getCurrent_city_name() {
		return current_city_name;
	}

	public void setCurrent_city_name(String current_city_name) {
		this.current_city_name = current_city_name;
	}

	public String getNative_city_name() {
		return native_city_name;
	}

	public void setNative_city_name(String native_city_name) {
		this.native_city_name = native_city_name;
	}

	public String getExpect_city_name() {
		return expect_city_name;
	}

	public void setExpect_city_name(String expect_city_name) {
		this.expect_city_name = expect_city_name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPending_company() {
		return pending_company;
	}

	public void setPending_company(String pending_company) {
		this.pending_company = pending_company;
	}

	public String getExpect_job_category_name() {
		return expect_job_category_name;
	}

	public void setExpect_job_category_name(String expect_job_category_name) {
		this.expect_job_category_name = expect_job_category_name;
	}

	public String getIs_liked() {
		return is_liked;
	}

	public void setIs_liked(String is_liked) {
		this.is_liked = is_liked;
	}

	public String getDownload_url() {
		return download_url;
	}

	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", sex=" + sex + ", alias=" + alias + ", email=" + email + ", mobile=" + mobile + ", company_id=" + company_id
				+ ", company_name=" + company_name + ", company_position=" + company_position + ", is_company_admin=" + is_company_admin + ", pending_company_id="
				+ pending_company_id + ", sign=" + sign + ", ctime=" + ctime + ", resume_percent=" + resume_percent + ", experience=" + experience + ", degree=" + degree
				+ ", photo_url=" + photo_url + ", introduction=" + introduction + ", birth_day=" + birth_day + ", work_status=" + work_status + ", current_city_id="
				+ current_city_id + ", native_city_id=" + native_city_id + ", expect_city_id=" + expect_city_id + ", expect_job_category_id=" + expect_job_category_id
				+ ", expect_min_salary=" + expect_min_salary + ", expect_max_salary=" + expect_max_salary + ", blog_url=" + blog_url + ", sina_weibo_url=" + sina_weibo_url
				+ ", github_url=" + github_url + ", zcool_url=" + zcool_url + ", domain_path=" + domain_path + ", current_city_name=" + current_city_name + ", native_city_name="
				+ native_city_name + ", expect_city_name=" + expect_city_name + ", company=" + company + ", pending_company=" + pending_company + ", expect_job_category_name="
				+ expect_job_category_name + ", is_liked=" + is_liked + ", download_url=" + download_url + "]";
	}

}
