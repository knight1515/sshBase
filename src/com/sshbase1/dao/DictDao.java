package com.sshbase1.dao;

import java.util.List;

import com.sshbase1.domain.Dict;

public interface DictDao {

	List<Dict> findByCode(String dict_type_code);

}
