package test.zoe.threadLocalTest;

import com.alibaba.ttl.TransmittableThreadLocal;

public class LoginContext {
	private static final ThreadLocal<LoginContext> holder = new TransmittableThreadLocal();

	String pin;

	Long tenantId;

	String appVersion;

	String rnVersion;

	String platCode;

	String systemName;

	String appId;

	String wsKey;

	String resolution;

	String channel;

	String imei;

	String deviceId;

	String apiVersion;

	String acceptCompress;

	String cookie;

	String action;

	String contentType;

	String account;

	public static LoginContext getLoginContext() {
		return (LoginContext) holder.get();
	}

	public static void setLoginContext(LoginContext loginContext) {
		holder.set(loginContext);
	}

	public static void removeLoginContext(){
		holder.remove();
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public static ThreadLocal<LoginContext> getHolder() {
		return holder;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getRnVersion() {
		return rnVersion;
	}

	public void setRnVersion(String rnVersion) {
		this.rnVersion = rnVersion;
	}

	public String getPlatCode() {
		return platCode;
	}

	public void setPlatCode(String platCode) {
		this.platCode = platCode;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getWsKey() {
		return wsKey;
	}

	public void setWsKey(String wsKey) {
		this.wsKey = wsKey;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getAcceptCompress() {
		return acceptCompress;
	}

	public void setAcceptCompress(String acceptCompress) {
		this.acceptCompress = acceptCompress;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}