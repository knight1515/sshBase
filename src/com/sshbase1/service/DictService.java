package com.sshbase1.service;

import java.util.List;

import com.sshbase1.domain.Dict;


public interface DictService {

	List<Dict> findByCode(String dict_type_code);

}
