package kodlamaio.hrms.core.utilities.results;

import kodlamaio.hrms.core.utilities.results.DataResult;

public class ErrorDataResult<T> extends DataResult {

	public ErrorDataResult(Object data, String message) {
		super(data, false, message);
	}
	
	public ErrorDataResult(Object data) {
		super(data, false);
	}
	
	public ErrorDataResult(String message) {
		super(null, false, message);
	}
}
