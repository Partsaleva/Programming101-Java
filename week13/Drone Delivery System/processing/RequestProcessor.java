package processing;

public class RequestProcessor {

	public void processRequest(String type, String request){
		if (type.equals("supply")) {
			processSupplyRequest(request);
		} else {
			processDeliveryRequest(request);
		}
	}

	private void processDeliveryRequest(String request) {
		
		
	}

	private void processSupplyRequest(String request) {
		
		
	}
}
