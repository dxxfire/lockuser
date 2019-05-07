package cn.bobdeng.smartlock.lockuser;

class TimeRange {
    Long start;
    Long end;

    public TimeRange(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public TimeRange() {

    }

    public boolean notExpire() {
        if(start==null || end==null){
            return true;
        }
        return LockUserRepositories.currentTime()>=start && LockUserRepositories.currentTime()<=end;
    }

    public boolean overflow(long start, long end) {
        if(this.start==null || this.end==null){
            return false;
        }
        return this.start<=start || this.end>=end;
    }
}
