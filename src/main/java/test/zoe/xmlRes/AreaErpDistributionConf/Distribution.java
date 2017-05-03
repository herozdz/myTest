package test.zoe.xmlRes.AreaErpDistributionConf;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/3/24
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 * 配送中心实体
 */
public class Distribution {

    /**
     * 配送中心id
     * */
    private Integer id;

    /**
     * 配送中心名称
     * */
    private String name;

    /**
     * 指定推送库房id（推送库房信息：一个配送中心只推送一个库房）
     * */
    private Integer storeId;

    /**
     * 指定推送库房名称
     * */
    private String storeName;

    /**
     * 1:有效，0：无效
     * */
    private Integer yn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Distribution{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", storeId=").append(storeId);
        sb.append(", storeName='").append(storeName).append('\'');
        sb.append(", yn=").append(yn);
        sb.append('}');
        return sb.toString();
    }
}
