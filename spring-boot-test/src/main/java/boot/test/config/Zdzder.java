package boot.test.config;

import lombok.ToString;

/**
 * @author Zoe
 * @date 2020-04-03 21:05
 */

@lombok.Builder
@ToString
public class Zdzder {

    private String  name;

    private String  code;


    public static void main(String[] args) {
        Zdzder build = new ZdzderBuilder().code("001").build();
        System.out.println(build);
    }

}
