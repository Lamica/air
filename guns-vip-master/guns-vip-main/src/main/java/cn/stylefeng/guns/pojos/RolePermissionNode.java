package cn.stylefeng.guns.pojos;

import cn.stylefeng.guns.pojo.PermissionNode;

import java.util.List;

public class RolePermissionNode extends RolePermission {
    private List<RolePermissionNode> children;

    public RolePermissionNode() {
    }

    public RolePermissionNode(List<RolePermissionNode> children) {
        this.children = children;
    }

    public List<RolePermissionNode> getChildren() {
        return children;
    }

    public void setChildren(List<RolePermissionNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "RolePermissionNode{" +
                "children=" + children +
                '}';
    }
}
