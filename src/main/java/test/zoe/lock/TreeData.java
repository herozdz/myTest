package test.zoe.lock;

/**
 * @author Zoe
 * @date 2020/7/2 下午2:07
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeData implements Serializable {
    String value;
    String label;
    Boolean selectable;
    Double rank;
    List<TreeData> children;

    public TreeData() {
    }

    public TreeData(String pValue, String pLabel) {
        this.value = pValue;
        this.label = pLabel;
    }

    public TreeData(String pValue, String pLabel, Boolean selectable) {
        this.value = pValue;
        this.label = pLabel;
        this.selectable = selectable;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String pValue) {
        this.value = pValue;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String pLabel) {
        this.label = pLabel;
    }

    public List<TreeData> getChildren() {
        return this.children;
    }

    public void setChildren(List<TreeData> pChildren) {
        this.children = pChildren;
    }

    public void addChildren(TreeData pChildren) {
        if (this.children == null) {
            this.children = new ArrayList();
        }

        this.children.add(pChildren);
    }

    public Boolean getSelectable() {
        return this.selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    public Double getRank() {
        return this.rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }
}
