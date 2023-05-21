package com.cenyu.prototype.shallow;

public class ShallowClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        Wife wife = new Wife(new Param(20, 165));
        Wife clone1 = wife.clone();
        Wife clone2 = wife.clone();
        Wife clone3 = wife.clone();

        /*
            In the case of shallow copy, modifying the reference data type of clone2
            will affect other cloned objects
         */
        clone2.getParam().setAge(18);
        clone2.getParam().setHeight(170);

        System.out.println(clone1);
        System.out.println(clone2);
        System.out.println(clone3);
    }
}

class Param {

    private Integer age;
    private Integer height;

    public Param(Integer age, Integer height) {
        this.age = age;
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Param{" +
                "age=" + age +
                ", height=" + height +
                '}';
    }
}

class Wife implements Cloneable {

    private Param param;

    public Wife(Param param) {
        this.param = param;
    }

    public Param getParam() {
        return param;
    }

    public void setParam(Param param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "param=" + param +
                '}';
    }

    @Override
    protected Wife clone() throws CloneNotSupportedException {
        return (Wife) super.clone();
    }
}
