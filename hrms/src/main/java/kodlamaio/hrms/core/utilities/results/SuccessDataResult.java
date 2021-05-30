package kodlamaio.hrms.core.utilities.results;

import kodlamaio.hrms.core.utilities.results.DataResult;

public class SuccessDataResult<T> extends DataResult {

	public SuccessDataResult(Object data, String message) {
		super(data, true, message);
	}
	
	public SuccessDataResult(Object data) {
		super(data, true);
	}
	
	public SuccessDataResult(String message) {
		super(null, true, message);
	}
}
