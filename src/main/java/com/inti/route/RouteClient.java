package com.inti.route;

import javax.sql.DataSource;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import com.inti.process.ProcessGetAllClient;


@Service
public class RouteClient extends RouteBuilder {

	@Autowired
	DataSource dataSource;
	
	@Override
	public void configure() throws Exception {
		from("direct:selectAchat")
		.setBody(constant("select * from Achat_Projet"))
		.to("jdbc:dataSource");
		//.process(new ProcessGetAllClient());
		
		
		from("direct:selectLocation")
		.setBody(constant("select * from Location_Projet"))
		.to("jdbc:dataSource");
		//.process(new ProcessGetAllClient());
	}

}
