package cn.stylefeng.guns.pojo;

import java.util.List;

public class PermissionNode extends Permission {

    private List<PermissionNode> children;

    public PermissionNode() {
    }

    public PermissionNode(List<PermissionNode> children) {
        this.children = children;
    }

    public List<PermissionNode> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "PermissionNode{" +
                "children=" + children +
                '}';
    }
}
