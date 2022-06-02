package com.lokutson.producing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public interface FileRepository extends CrudRepository<File, Long> {}