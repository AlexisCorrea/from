package ApiPersona.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

@Service
public class AmazonS3Service {
	private AmazonS3 s3client;

	@Value("${amazon.s3.endpoint}")
	private String endpointUrl;
	@Value("${amazon.s3.bucketname}")
	private String bucketName;
	@Value("${amazon.aws.accesskey}")
	private String accessKey;
	@Value("${amazon.aws.secretkey}")
	private String secretKey;

	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = new AmazonS3Client(credentials);
	}

	@Bean
	public AmazonS3 getClient() {
		return s3client;
	}
}
