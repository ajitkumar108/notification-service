package com.example.notification_service.dto;

public class DashboardResponse {

    private long totalNotifications;

    public long getTotalNotifications() {
        return totalNotifications;
    }
    public void setTotalNotification(long totalNotifications) {
        this.totalNotifications = totalNotifications;
    }

    private long sent;

    public long getSent() {
        return sent;
    }
    public void setSent(long sent) {
        this.sent = sent;
    }

    private long failed;

    public long getFailed() {
        return failed;
    }
    public void setFailed(long failed) {
        this.failed = failed;
    }

    private long deliveryLogs;

    public long getDeliveryLogs() {
        return deliveryLogs;
    }
    public void setDeliveryLogs(long deliveryLogs) {
        this.deliveryLogs = deliveryLogs;
    }
}
