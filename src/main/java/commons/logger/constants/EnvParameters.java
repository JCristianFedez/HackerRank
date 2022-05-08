package commons.logger.constants;

public enum EnvParameters {
  LOG4J_URL("src/main/resources/config/log4j.xml");

  private final String value;

  EnvParameters(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
