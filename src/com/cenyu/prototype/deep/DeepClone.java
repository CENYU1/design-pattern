package com.cenyu.prototype.deep;

import java.io.*;

public class DeepClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        Wife wife = new Wife(new Param(18, 170));
        Wife clone1 = wife.clone();
        Wife clone2 = wife.clone();
        Wife clone3 = wife.clone();

        /*
            In the case of deep copy, changing the reference data type of clone2
            does not affect other cloned objects
         */
        clone2.getParam().setAge(20);
        clone2.getParam().setHeight(165);

        System.out.println(clone1);
        System.out.println(clone2);
        System.out.println(clone3);
    }
}

class Param implements Serializable {

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

class Wife implements Serializable, Cloneable {

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

        /*
            Because the parent class is a shallow clone by default, we need to
            implement deep copy by stream
         */
        Wife clone = (Wife) super.clone();

        try {
            // Write a cloned object to a byte stream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(baos);
            os.writeObject(clone);

            // Read and retrieve objects from the stream
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream is = new ObjectInputStream(bais);
            return (Wife) is.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
