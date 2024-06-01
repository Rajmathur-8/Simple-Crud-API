package com.crud_api.demo;

import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

@SpringBootApplication
public class SimpleCrudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCrudApiApplication.class, args);
		
	}

}
