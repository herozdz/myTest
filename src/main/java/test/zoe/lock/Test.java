package test.zoe.lock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

/**
 * @author Zoe
 * @date 2020/7/2 下午2:08
 */
public class Test {
    static String tree = "[{\n" +
            "        \"value\": \"405\",\n" +
            "        \"label\": \"测试商品（勿用）21121141\",\n" +
            "        \"selectable\": null,\n" +
            "        \"rank\": null,\n" +
            "        \"children\": [{\n" +
            "            \"value\": \"2746\",\n" +
            "            \"label\": \"测试销售 请勿使用\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"2746\",\n" +
            "                \"label\": \"测试销售 请勿使用\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }, {\n" +
            "            \"value\": \"406\",\n" +
            "            \"label\": \"测试商品岗（勿用）111\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"406\",\n" +
            "                \"label\": \"测试商品岗（勿用）111\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"value\": \"409\",\n" +
            "        \"label\": \"团购\",\n" +
            "        \"selectable\": null,\n" +
            "        \"rank\": null,\n" +
            "        \"children\": [{\n" +
            "            \"value\": \"410\",\n" +
            "            \"label\": \"实物类团购\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"446\",\n" +
            "                \"label\": \"生活家电\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"448\",\n" +
            "                \"label\": \"运动户外\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"452\",\n" +
            "                \"label\": \"食品保健\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"value\": \"414\",\n" +
            "        \"label\": \"产品管理部\",\n" +
            "        \"selectable\": null,\n" +
            "        \"rank\": null,\n" +
            "        \"children\": [{\n" +
            "            \"value\": \"415\",\n" +
            "            \"label\": \"产品管理部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"858\",\n" +
            "                \"label\": \"产品管理部费用收取\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"value\": \"417\",\n" +
            "        \"label\": \"企业业务事业部\",\n" +
            "        \"selectable\": null,\n" +
            "        \"rank\": null,\n" +
            "        \"children\": [{\n" +
            "            \"value\": \"3308\",\n" +
            "            \"label\": \"创新与工业品部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"3421\",\n" +
            "                \"label\": \"工业品采销部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }, {\n" +
            "            \"value\": \"3452\",\n" +
            "            \"label\": \"通用商品采销部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"3453\",\n" +
            "                \"label\": \"通用商品采销部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }, {\n" +
            "            \"value\": \"423\",\n" +
            "            \"label\": \"综合支持\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"424\",\n" +
            "                \"label\": \"礼品卡支持\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"value\": \"4218\",\n" +
            "        \"label\": \"运动户外部\",\n" +
            "        \"selectable\": null,\n" +
            "        \"rank\": null,\n" +
            "        \"children\": [{\n" +
            "            \"value\": \"4219\",\n" +
            "            \"label\": \"运动部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"4228\",\n" +
            "                \"label\": \"国际旗舰部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4230\",\n" +
            "                \"label\": \"运动潮流部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4232\",\n" +
            "                \"label\": \"国际专营部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4234\",\n" +
            "                \"label\": \"自营国际品牌组\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4236\",\n" +
            "                \"label\": \"国内品牌部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4238\",\n" +
            "                \"label\": \"自营国内品牌组\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }, {\n" +
            "            \"value\": \"4220\",\n" +
            "            \"label\": \"健身部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"4240\",\n" +
            "                \"label\": \"健身器材部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4242\",\n" +
            "                \"label\": \"自营健身器材组\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4244\",\n" +
            "                \"label\": \"体育用品部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4246\",\n" +
            "                \"label\": \"自营体育用品组\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }, {\n" +
            "            \"value\": \"4221\",\n" +
            "            \"label\": \"户外部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"4248\",\n" +
            "                \"label\": \"户外鞋服部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4250\",\n" +
            "                \"label\": \"户外装备部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4252\",\n" +
            "                \"label\": \"垂钓部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4254\",\n" +
            "                \"label\": \"游泳滑雪部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4256\",\n" +
            "                \"label\": \"骑行部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4258\",\n" +
            "                \"label\": \"自营户外鞋服组\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4260\",\n" +
            "                \"label\": \"自营户外装备组\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4262\",\n" +
            "                \"label\": \"自营垂钓组\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4264\",\n" +
            "                \"label\": \"自营游泳滑雪组\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"4266\",\n" +
            "                \"label\": \"自营骑行组\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"value\": \"4384\",\n" +
            "        \"label\": \"1号会员店业务部\",\n" +
            "        \"selectable\": null,\n" +
            "        \"rank\": null,\n" +
            "        \"children\": [{\n" +
            "            \"value\": \"4385\",\n" +
            "            \"label\": \"商品买手部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"4395\",\n" +
            "                \"label\": \"买手一组\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"value\": \"582\",\n" +
            "        \"label\": \"全球购业务部-KA运营组\",\n" +
            "        \"selectable\": null,\n" +
            "        \"rank\": null,\n" +
            "        \"children\": [{\n" +
            "            \"value\": \"2998\",\n" +
            "            \"label\": \"测试二级非最小销售岗2，请勿使用\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"2999\",\n" +
            "                \"label\": \"测试三级最小销售岗2，请勿使用\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }, {\n" +
            "            \"value\": \"788\",\n" +
            "            \"label\": \"KA运营组\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"789\",\n" +
            "                \"label\": \"KA运营组\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"value\": \"585\",\n" +
            "        \"label\": \"生活旅行业务部\",\n" +
            "        \"selectable\": null,\n" +
            "        \"rank\": null,\n" +
            "        \"children\": [{\n" +
            "            \"value\": \"2226\",\n" +
            "            \"label\": \"酒店业务部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"2229\",\n" +
            "                \"label\": \"国际酒店业务部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"2231\",\n" +
            "                \"label\": \"国内酒店业务部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"2233\",\n" +
            "                \"label\": \"酒店旗舰店业务部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }, {\n" +
            "            \"value\": \"2227\",\n" +
            "            \"label\": \"机票业务部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"2235\",\n" +
            "                \"label\": \"国际机票业务部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"2237\",\n" +
            "                \"label\": \"航空周边业务部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"2243\",\n" +
            "                \"label\": \"国内机票业务部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }, {\n" +
            "            \"value\": \"3426\",\n" +
            "            \"label\": \"渠道拓展部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"4356\",\n" +
            "                \"label\": \"地面交通\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }, {\n" +
            "            \"value\": \"594\",\n" +
            "            \"label\": \"生活业务部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"1811\",\n" +
            "                \"label\": \"生活缴费部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"1820\",\n" +
            "                \"label\": \"娱乐业务部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"600\",\n" +
            "                \"label\": \"票务卡券部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"601\",\n" +
            "                \"label\": \"生活服务部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }, {\n" +
            "            \"value\": \"596\",\n" +
            "            \"label\": \"旅游业务部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"3694\",\n" +
            "                \"label\": \"度假\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }, {\n" +
            "                \"value\": \"3695\",\n" +
            "                \"label\": \"景区乐园\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"value\": \"586\",\n" +
            "        \"label\": \"新业务部\",\n" +
            "        \"selectable\": null,\n" +
            "        \"rank\": null,\n" +
            "        \"children\": [{\n" +
            "            \"value\": \"587\",\n" +
            "            \"label\": \"商务运营部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"590\",\n" +
            "                \"label\": \"创新产品业务部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"value\": \"825\",\n" +
            "        \"label\": \"O2O业务部\",\n" +
            "        \"selectable\": null,\n" +
            "        \"rank\": null,\n" +
            "        \"children\": [{\n" +
            "            \"value\": \"836\",\n" +
            "            \"label\": \"商务运营部\",\n" +
            "            \"selectable\": null,\n" +
            "            \"rank\": null,\n" +
            "            \"children\": [{\n" +
            "                \"value\": \"838\",\n" +
            "                \"label\": \"商务拓展部\",\n" +
            "                \"selectable\": null,\n" +
            "                \"rank\": null,\n" +
            "                \"children\": null\n" +
            "            }]\n" +
            "        }]\n" +
            "    }]";
    public static void main(String[] args) {
        JSONArray array = JSON.parseArray(tree);
        for(int i=0;i<array.size();i++){
            JSONObject level1Obj = array.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
            String valueLevel1 = (String)level1Obj.get("value");
            String labelLevel1 = (String)level1Obj.get("label");
            JSONArray level2Array = (JSONArray)level1Obj.get("children");
            if(null != level2Array){
                for(int j=0;j<level2Array.size();j++){
                    JSONObject level2Obj = level2Array.getJSONObject(j);
                    String valueLevel2 = (String)level2Obj.get("value");
                    String labelLevel2 = (String)level2Obj.get("label");
                    JSONArray level3Array = (JSONArray)level2Obj.get("children");
                    if(null != level3Array){
                        for(int k=0;k<level3Array.size();k++){
                            JSONObject level3Obj = level3Array.getJSONObject(k);
                            String valueLevel3 = (String)level3Obj.get("value");
                            String labelLevel3 = (String)level3Obj.get("label");
                            System.out.println(valueLevel1+","+labelLevel1+","+valueLevel2+","+labelLevel2+","+valueLevel3+","+labelLevel3);
                        }
                    }
                }
            }
        }
    }
}
