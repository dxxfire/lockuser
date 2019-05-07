package cn.bobdeng.smartlock.lockuser;

import java.util.Objects;

public class LockUser {
    LockUserId id;
    Assign assign;

    public LockUser(LockUserId id, Assign assign) {
        this.id = id;
        this.assign = assign;
    }

    public boolean isOwner() {
        return assign.isOwner();
    }

    public LockUser createUser(String lockId, String userId, UserLevel userLevel) {
        LockUser lockUser = new LockUser(new LockUserId(lockId,userId), Assign.newUser(userLevel));
        LockUserRepositories.saveLockUser(lockUser);
        return lockUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LockUser lockUser = (LockUser) o;
        return Objects.equals(id, lockUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean canManage(UserLevel userLevel) {
        return assign.canManage(userLevel);
    }
}