package com.chatIn.properties;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.concurrent.TimeUnit;

@XStreamAlias("executorSpec")
public class ExecutorSpec {

  @XStreamAlias("corePoolSize")
  private int corePoolSize = 256;

  @XStreamAlias("maximumPoolSize")
  private int maximumPoolSize = 256;
  @XStreamAlias("keepAlivaTime")
  private long keepAlivaTime = 60;


  @XStreamAlias("keepAlivaTimeUnit")
  private TimeUnit timeUnit = TimeUnit.SECONDS;

  @XStreamAlias("threadFactoryName")
  private String threadFactoryName = "Thread";

  @XStreamAlias("useDaemonThreads")
  private boolean useDaemonThreads = false;

  @XStreamAlias("allowCorePoolThreadTimeout")
  private boolean allowCorePoolThreadTimeout;

  public ExecutorSpec() {
  }

  public ExecutorSpec(int corePoolSize, int maximumPoolSize, long keepAlivaTime, TimeUnit timeUnit, String threadFactoryName, boolean useDaemonThreads) {
    this.corePoolSize = corePoolSize;
    this.maximumPoolSize = maximumPoolSize;
    this.keepAlivaTime = keepAlivaTime;
    this.timeUnit = timeUnit;
    this.threadFactoryName = threadFactoryName;
    this.useDaemonThreads = useDaemonThreads;
  }

  public ExecutorSpec(int corePoolSize, int maximumPoolSize, long keepAlivaTime, TimeUnit timeUnit, String threadFactoryName, boolean useDaemonThreads, boolean allowCorePoolThreadTimeout) {
    this.corePoolSize = corePoolSize;
    this.maximumPoolSize = maximumPoolSize;
    this.keepAlivaTime = keepAlivaTime;
    this.timeUnit = timeUnit;
    this.threadFactoryName = threadFactoryName;
    this.useDaemonThreads = useDaemonThreads;
    this.allowCorePoolThreadTimeout = allowCorePoolThreadTimeout;
  }

  public int getCorePoolSize() {
    return corePoolSize;
  }

  public ExecutorSpec setCorePoolSize(int corePoolSize) {
    this.corePoolSize = corePoolSize;
    return this;
  }

  public int getMaximumPoolSize() {
    return maximumPoolSize;
  }

  public long getKeepAlivaTime() {
    return keepAlivaTime;
  }

  public TimeUnit getTimeUnit() {
    return timeUnit;
  }

  public ExecutorSpec setTimeUnit(TimeUnit timeUnit) {
    this.timeUnit = timeUnit;
    return this;
  }

  public ExecutorSpec setMaximumPoolSize(int maximumPoolSize) {
    this.maximumPoolSize = maximumPoolSize;
    return this;
  }

  public ExecutorSpec setKeepAlivaTime(long keepAlivaTime) {
    this.keepAlivaTime = keepAlivaTime;
    return this;
  }


  public String getThreadFactoryName() {
    return threadFactoryName;
  }

  public ExecutorSpec setThreadFactoryName(String threadFactoryName) {
    this.threadFactoryName = threadFactoryName;
    return this;
  }

  public boolean isUseDaemonThreads() {
    return useDaemonThreads;
  }

  public ExecutorSpec setUseDaemonThreads(boolean useDaemonThreads) {
    this.useDaemonThreads = useDaemonThreads;
    return this;
  }

  @Override
  public String toString() {
    return
      "CorePoolSize=" + corePoolSize +
        ", MaximumPoolSize=" + maximumPoolSize +
        ", KeepAlivaTime=" + keepAlivaTime +
        ", TimeUnit=" + timeUnit +
        ", ThreadFactoryName=" + threadFactoryName +
        ", UseDaemonThreads=" + useDaemonThreads +
        ", AllowCorePoolThreadTimeout=" + allowCorePoolThreadTimeout;
  }

  public boolean isAllowCorePoolThreadTimeout() {
    return allowCorePoolThreadTimeout;
  }

  public ExecutorSpec setAllowCorePoolThreadTimeout(boolean allowCorePoolThreadTimeout) {
    this.allowCorePoolThreadTimeout = allowCorePoolThreadTimeout;
    return this;
  }
}

