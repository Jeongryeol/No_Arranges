package com.ch08;

import java.util.List;
import java.util.Map;

public class JobSimulation {

	public static void main(String[] args) {
		JobDao jDao = new JobDao();
		List<Map<String,Object>> jobList = jDao.getJobList("1");
		System.out.println("조회건 수 : "+jobList.size());
	}

}
