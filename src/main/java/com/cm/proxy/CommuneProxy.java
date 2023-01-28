package com.cm.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cm.beans.CommuneBean;

@FeignClient(name = "microservice-organisation")
public interface CommuneProxy {
	
	@GetMapping(value = "${communes.show.url}")
	CommuneBean getCommuneById(@PathVariable("id") long id);
}
