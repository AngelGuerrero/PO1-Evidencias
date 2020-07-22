interface CallBack {
	void methodToCallBack();
}

class CallBackImpl implements CallBack {
	public void methodToCallBack() {
		System.out.println("I've been called back");
	}
}

public class Main {

	public void register(CallBack callback) {
		callback.methodToCallBack();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		CallBack callBack = new CallBackImpl();
		main.register(callBack);
	}
}
