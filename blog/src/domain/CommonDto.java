package domain;

import lombok.Data;

@Data
public class CommonDto<T> {

	public int statusCode;
	public T data;
}
