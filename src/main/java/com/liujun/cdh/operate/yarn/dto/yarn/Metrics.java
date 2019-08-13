package com.liujun.cdh.operate.yarn.dto.yarn;

/**
 * 返回资源的整体信息
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/13
 */
public class Metrics {

  /** The number of applications submitted */
  private int appsSubmitted;

  /** The number of applications completed */
  private int appsCompleted;

  /** The number of applications pending */
  private int appsPending;

  /** The number of applications running */
  private int appsRunning;

  /** The number of applications failed */
  private int appsFailed;

  /** The number of applications killed */
  private int appsKilled;

  /** The amount of memory reserved in MB */
  private long reservedMB;

  /** The amount of memory available in MB */
  private long availableMB;

  /** The amount of memory allocated in MB */
  private long allocatedMB;

  /** The amount of total memory in MB */
  private long totalMB;

  /** The number of reserved virtual cores */
  private long reservedVirtualCores;

  /** The number of available virtual cores */
  private long availableVirtualCores;

  /** The number of allocated virtual cores */
  private long allocatedVirtualCores;

  /** The total number of virtual cores */
  private long totalVirtualCores;

  /** The number of containers allocated */
  private int containersAllocated;

  /** The number of containers reserved */
  private int containersReserved;

  /** The number of containers pending */
  private int containersPending;

  /** The total number of nodes */
  private int totalNodes;

  /** The number of active nodes */
  private int activeNodes;

  /** The number of lost nodes */
  private int lostNodes;

  /** The number of unhealthy nodes */
  private int unhealthyNodes;

  /** The number of nodes decommissioned */
  private int decommissionedNodes;

  /** The number of nodes rebooted */
  private int rebootedNodes;

  public int getAppsSubmitted() {
    return appsSubmitted;
  }

  public void setAppsSubmitted(int appsSubmitted) {
    this.appsSubmitted = appsSubmitted;
  }

  public int getAppsCompleted() {
    return appsCompleted;
  }

  public void setAppsCompleted(int appsCompleted) {
    this.appsCompleted = appsCompleted;
  }

  public int getAppsPending() {
    return appsPending;
  }

  public void setAppsPending(int appsPending) {
    this.appsPending = appsPending;
  }

  public int getAppsRunning() {
    return appsRunning;
  }

  public void setAppsRunning(int appsRunning) {
    this.appsRunning = appsRunning;
  }

  public int getAppsFailed() {
    return appsFailed;
  }

  public void setAppsFailed(int appsFailed) {
    this.appsFailed = appsFailed;
  }

  public int getAppsKilled() {
    return appsKilled;
  }

  public void setAppsKilled(int appsKilled) {
    this.appsKilled = appsKilled;
  }

  public long getReservedMB() {
    return reservedMB;
  }

  public void setReservedMB(long reservedMB) {
    this.reservedMB = reservedMB;
  }

  public long getAvailableMB() {
    return availableMB;
  }

  public void setAvailableMB(long availableMB) {
    this.availableMB = availableMB;
  }

  public long getAllocatedMB() {
    return allocatedMB;
  }

  public void setAllocatedMB(long allocatedMB) {
    this.allocatedMB = allocatedMB;
  }

  public long getTotalMB() {
    return totalMB;
  }

  public void setTotalMB(long totalMB) {
    this.totalMB = totalMB;
  }

  public long getReservedVirtualCores() {
    return reservedVirtualCores;
  }

  public void setReservedVirtualCores(long reservedVirtualCores) {
    this.reservedVirtualCores = reservedVirtualCores;
  }

  public long getAvailableVirtualCores() {
    return availableVirtualCores;
  }

  public void setAvailableVirtualCores(long availableVirtualCores) {
    this.availableVirtualCores = availableVirtualCores;
  }

  public long getAllocatedVirtualCores() {
    return allocatedVirtualCores;
  }

  public void setAllocatedVirtualCores(long allocatedVirtualCores) {
    this.allocatedVirtualCores = allocatedVirtualCores;
  }

  public long getTotalVirtualCores() {
    return totalVirtualCores;
  }

  public void setTotalVirtualCores(long totalVirtualCores) {
    this.totalVirtualCores = totalVirtualCores;
  }

  public int getContainersAllocated() {
    return containersAllocated;
  }

  public void setContainersAllocated(int containersAllocated) {
    this.containersAllocated = containersAllocated;
  }

  public int getContainersReserved() {
    return containersReserved;
  }

  public void setContainersReserved(int containersReserved) {
    this.containersReserved = containersReserved;
  }

  public int getContainersPending() {
    return containersPending;
  }

  public void setContainersPending(int containersPending) {
    this.containersPending = containersPending;
  }

  public int getTotalNodes() {
    return totalNodes;
  }

  public void setTotalNodes(int totalNodes) {
    this.totalNodes = totalNodes;
  }

  public int getActiveNodes() {
    return activeNodes;
  }

  public void setActiveNodes(int activeNodes) {
    this.activeNodes = activeNodes;
  }

  public int getLostNodes() {
    return lostNodes;
  }

  public void setLostNodes(int lostNodes) {
    this.lostNodes = lostNodes;
  }

  public int getUnhealthyNodes() {
    return unhealthyNodes;
  }

  public void setUnhealthyNodes(int unhealthyNodes) {
    this.unhealthyNodes = unhealthyNodes;
  }

  public int getDecommissionedNodes() {
    return decommissionedNodes;
  }

  public void setDecommissionedNodes(int decommissionedNodes) {
    this.decommissionedNodes = decommissionedNodes;
  }

  public int getRebootedNodes() {
    return rebootedNodes;
  }

  public void setRebootedNodes(int rebootedNodes) {
    this.rebootedNodes = rebootedNodes;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Metrics{");
    sb.append("appsSubmitted=").append(appsSubmitted);
    sb.append(", appsCompleted=").append(appsCompleted);
    sb.append(", appsPending=").append(appsPending);
    sb.append(", appsRunning=").append(appsRunning);
    sb.append(", appsFailed=").append(appsFailed);
    sb.append(", appsKilled=").append(appsKilled);
    sb.append(", reservedMB=").append(reservedMB);
    sb.append(", availableMB=").append(availableMB);
    sb.append(", allocatedMB=").append(allocatedMB);
    sb.append(", totalMB=").append(totalMB);
    sb.append(", reservedVirtualCores=").append(reservedVirtualCores);
    sb.append(", availableVirtualCores=").append(availableVirtualCores);
    sb.append(", allocatedVirtualCores=").append(allocatedVirtualCores);
    sb.append(", totalVirtualCores=").append(totalVirtualCores);
    sb.append(", containersAllocated=").append(containersAllocated);
    sb.append(", containersReserved=").append(containersReserved);
    sb.append(", containersPending=").append(containersPending);
    sb.append(", totalNodes=").append(totalNodes);
    sb.append(", activeNodes=").append(activeNodes);
    sb.append(", lostNodes=").append(lostNodes);
    sb.append(", unhealthyNodes=").append(unhealthyNodes);
    sb.append(", decommissionedNodes=").append(decommissionedNodes);
    sb.append(", rebootedNodes=").append(rebootedNodes);
    sb.append('}');
    return sb.toString();
  }
}
