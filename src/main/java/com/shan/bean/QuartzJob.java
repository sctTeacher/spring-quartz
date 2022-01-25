//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shan.bean;

public class QuartzJob {
    public static final Integer STATUS_RUNNING = 1;
    public static final Integer STATUS_NOT_RUNNING = 0;
    public static final Integer CONCURRENT_IS = 1;
    public static final Integer CONCURRENT_NOT = 0;
    private String jobId;
    private String cronExpression;
    private String methodName;
    private Integer isConcurrent;
    private String description;
    private String beanName;
    private String triggerName;
    private Integer jobStatus;
    private String springBean;
    private String jobName;
    private String jobGroup;

    public String getJobId() {
        return this.jobId;
    }

    public String getCronExpression() {
        return this.cronExpression;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public Integer getIsConcurrent() {
        return this.isConcurrent;
    }

    public String getDescription() {
        return this.description;
    }

    public String getBeanName() {
        return this.beanName;
    }

    public String getTriggerName() {
        return this.triggerName;
    }

    public Integer getJobStatus() {
        return this.jobStatus;
    }

    public String getSpringBean() {
        return this.springBean;
    }

    public String getJobName() {
        return this.jobName;
    }

    public String getJobGroup() {
        return this.jobGroup;
    }

    public QuartzJob setJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public QuartzJob setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
        return this;
    }

    public QuartzJob setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public QuartzJob setIsConcurrent(Integer isConcurrent) {
        this.isConcurrent = isConcurrent;
        return this;
    }

    public QuartzJob setDescription(String description) {
        this.description = description;
        return this;
    }

    public QuartzJob setBeanName(String beanName) {
        this.beanName = beanName;
        return this;
    }

    public QuartzJob setTriggerName(String triggerName) {
        this.triggerName = triggerName;
        return this;
    }

    public QuartzJob setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
        return this;
    }

    public QuartzJob setSpringBean(String springBean) {
        this.springBean = springBean;
        return this;
    }

    public QuartzJob setJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public QuartzJob setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
        return this;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QuartzJob)) {
            return false;
        } else {
            QuartzJob other = (QuartzJob)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label143: {
                    Object this$isConcurrent = this.getIsConcurrent();
                    Object other$isConcurrent = other.getIsConcurrent();
                    if (this$isConcurrent == null) {
                        if (other$isConcurrent == null) {
                            break label143;
                        }
                    } else if (this$isConcurrent.equals(other$isConcurrent)) {
                        break label143;
                    }

                    return false;
                }

                Object this$jobStatus = this.getJobStatus();
                Object other$jobStatus = other.getJobStatus();
                if (this$jobStatus == null) {
                    if (other$jobStatus != null) {
                        return false;
                    }
                } else if (!this$jobStatus.equals(other$jobStatus)) {
                    return false;
                }

                Object this$jobId = this.getJobId();
                Object other$jobId = other.getJobId();
                if (this$jobId == null) {
                    if (other$jobId != null) {
                        return false;
                    }
                } else if (!this$jobId.equals(other$jobId)) {
                    return false;
                }

                label122: {
                    Object this$cronExpression = this.getCronExpression();
                    Object other$cronExpression = other.getCronExpression();
                    if (this$cronExpression == null) {
                        if (other$cronExpression == null) {
                            break label122;
                        }
                    } else if (this$cronExpression.equals(other$cronExpression)) {
                        break label122;
                    }

                    return false;
                }

                label115: {
                    Object this$methodName = this.getMethodName();
                    Object other$methodName = other.getMethodName();
                    if (this$methodName == null) {
                        if (other$methodName == null) {
                            break label115;
                        }
                    } else if (this$methodName.equals(other$methodName)) {
                        break label115;
                    }

                    return false;
                }

                Object this$description = this.getDescription();
                Object other$description = other.getDescription();
                if (this$description == null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                Object this$beanName = this.getBeanName();
                Object other$beanName = other.getBeanName();
                if (this$beanName == null) {
                    if (other$beanName != null) {
                        return false;
                    }
                } else if (!this$beanName.equals(other$beanName)) {
                    return false;
                }

                label94: {
                    Object this$triggerName = this.getTriggerName();
                    Object other$triggerName = other.getTriggerName();
                    if (this$triggerName == null) {
                        if (other$triggerName == null) {
                            break label94;
                        }
                    } else if (this$triggerName.equals(other$triggerName)) {
                        break label94;
                    }

                    return false;
                }

                label87: {
                    Object this$springBean = this.getSpringBean();
                    Object other$springBean = other.getSpringBean();
                    if (this$springBean == null) {
                        if (other$springBean == null) {
                            break label87;
                        }
                    } else if (this$springBean.equals(other$springBean)) {
                        break label87;
                    }

                    return false;
                }

                Object this$jobName = this.getJobName();
                Object other$jobName = other.getJobName();
                if (this$jobName == null) {
                    if (other$jobName != null) {
                        return false;
                    }
                } else if (!this$jobName.equals(other$jobName)) {
                    return false;
                }

                Object this$jobGroup = this.getJobGroup();
                Object other$jobGroup = other.getJobGroup();
                if (this$jobGroup == null) {
                    if (other$jobGroup != null) {
                        return false;
                    }
                } else if (!this$jobGroup.equals(other$jobGroup)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QuartzJob;
    }

    public int hashCode() {
        int PRIME = 56;
        int result = 1;
        Object $isConcurrent = this.getIsConcurrent();
         result = result * 59 + ($isConcurrent == null ? 43 : $isConcurrent.hashCode());
        Object $jobStatus = this.getJobStatus();
        result = result * 59 + ($jobStatus == null ? 43 : $jobStatus.hashCode());
        Object $jobId = this.getJobId();
        result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
        Object $cronExpression = this.getCronExpression();
        result = result * 59 + ($cronExpression == null ? 43 : $cronExpression.hashCode());
        Object $methodName = this.getMethodName();
        result = result * 59 + ($methodName == null ? 43 : $methodName.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        Object $beanName = this.getBeanName();
        result = result * 59 + ($beanName == null ? 43 : $beanName.hashCode());
        Object $triggerName = this.getTriggerName();
        result = result * 59 + ($triggerName == null ? 43 : $triggerName.hashCode());
        Object $springBean = this.getSpringBean();
        result = result * 59 + ($springBean == null ? 43 : $springBean.hashCode());
        Object $jobName = this.getJobName();
        result = result * 59 + ($jobName == null ? 43 : $jobName.hashCode());
        Object $jobGroup = this.getJobGroup();
        result = result * 59 + ($jobGroup == null ? 43 : $jobGroup.hashCode());
        return result;
    }

    public String toString() {
        return "QuartzJob(jobId=" + this.getJobId() + ", cronExpression=" + this.getCronExpression() + ", methodName=" + this.getMethodName() + ", isConcurrent=" + this.getIsConcurrent() + ", description=" + this.getDescription() + ", beanName=" + this.getBeanName() + ", triggerName=" + this.getTriggerName() + ", jobStatus=" + this.getJobStatus() + ", springBean=" + this.getSpringBean() + ", jobName=" + this.getJobName() + ", jobGroup=" + this.getJobGroup() + ")";
    }

    public QuartzJob() {
    }

    public QuartzJob(String jobId, String cronExpression, String methodName, Integer isConcurrent, String description, String beanName, String triggerName, Integer jobStatus, String springBean, String jobName, String jobGroup) {
        this.jobId = jobId;
        this.cronExpression = cronExpression;
        this.methodName = methodName;
        this.isConcurrent = isConcurrent;
        this.description = description;
        this.beanName = beanName;
        this.triggerName = triggerName;
        this.jobStatus = jobStatus;
        this.springBean = springBean;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
    }
}
