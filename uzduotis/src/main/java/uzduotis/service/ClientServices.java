package uzduotis.service;

import org.springframework.stereotype.Service;

import com.cardinity.CardinityClient;

@Service
public class ClientServices {

	
	public CardinityClient getClient() {
		String consumerKey = "test_xwtk3yqf1xfjw4o0yi3gc45bccfuoa";
		String consumerSercret = "hntcg2mri0a9ghvaigtoyplm8acjbnd1hkyoudhbs0pdtd6qch";
		CardinityClient client = new CardinityClient(consumerKey, consumerSercret);
		return client;
	}
}
