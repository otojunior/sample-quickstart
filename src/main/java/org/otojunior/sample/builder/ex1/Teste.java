package org.otojunior.sample.builder.ex1;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Teste {
	private String um;
	private Integer dois;
	private Double tres;
}
