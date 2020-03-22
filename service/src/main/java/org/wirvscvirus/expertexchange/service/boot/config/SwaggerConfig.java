package org.wirvscvirus.expertexchange.service.boot.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author bahlef
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Autowired
	private RelativePathProvider pathProvider;

	@Bean
	public Docket api(ServletContext servletContext) {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.paths(Predicates.not(PathSelectors.regex("^(/actuator|/cloudfoundryapplication|/error).*$")))
				.apis(RequestHandlerSelectors.any()).build().apiInfo(apiInfo()).pathProvider(pathProvider);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API documentation")
				.contact(new Contact("expertexchange", "https://exex.eu-gb.cf.appdomain.cloud/", "nospam@us.thx"))
				.version("0.0.1").build();
	}

	public static class ApiPathProvider extends RelativePathProvider {
		@Bean
		RelativePathProvider pathProvider(ServletContext servletContext) {
			return new ApiPathProvider(servletContext);
		}

		public ApiPathProvider(ServletContext servletContext) {
			super(servletContext);
		}

		@Override
		protected String getDocumentationPath() {
			return getAppPathAsPrefix(this.getApplicationBasePath()) + "api";
		}

		private String getAppPathAsPrefix(String path) {
			if (!path.endsWith("/")) {
				path += "/";
			}

			return path;
		}
	}
}