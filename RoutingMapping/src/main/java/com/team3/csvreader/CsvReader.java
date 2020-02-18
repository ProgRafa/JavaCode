package com.team3.csvreader;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.*;

import java.util.stream.Collectors;

public class CsvReader<T> {

    private String[] header;
    private Class classInfo;
    private File file;

    public CsvReader(Class classInfo, File file) throws DataIncorrectException {
        this.classInfo = classInfo;
        this.file = file;
    }

    private Scanner getScanner(File file){
        try{
            return new Scanner(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<T> getData() {
        setHeaderDataLine();
        List<String> lines = getJustDataLines();
        return getItemList(lines);
    }

    private void setHeaderDataLine(){
        Scanner scanner = getScanner(file);
        if(scanner.hasNext()){
            String line = scanner.nextLine();
            header = line.split(",");
        }
    }

    private List<String> getJustDataLines(){
        List<String> lines = new ArrayList<>();
        Scanner scanner = getScanner(file);
        scanner = scanner.reset();
        scanner.nextLine();

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            line = fixUnformatedLines(line);
            lines.add(line);
        }
        return lines;
    }

    private String fixUnformatedLines(String line){
        if(line.contains("\"")){
            String response = "" ;
            String[] data = line.split("\"");
            for (String datas : data){
                String updatedValue = datas.replace(",", "");
                if(datas.indexOf(",") != 0 && isNumber(updatedValue))
                    response += updatedValue;
                else response += datas;
            }
            line = response;
        }
        return line;
    }

    private boolean isNumber(String number){
        return number.matches("-?(0|[1-9]\\d*)");
    }

    private List<T> getItemList(List<String> lines) {
        List<T> items = new ArrayList<>();
        for (String line : lines){
            T item = parseStringToItem(line);
            items.add(item);
        }
        return items;
    }

    private T parseStringToItem(String line) {
        List<DataAttribute> attributes = getAttributes(line);
        T dataItem = createEmptyInstance();
        List<Method> setters = getClassAnnotatedSetters();

        for (Method setter : setters){
            CsvAttributeSetter attributeSetter = setter.getAnnotation(CsvAttributeSetter.class);
            invokeSetter(dataItem, setter, attributeSetter, attributes);
        }

        return dataItem;
    }

    private List<DataAttribute> getAttributes(String line){
        List<DataAttribute> attributes = new ArrayList<>();
        String[] attributesUnformated = line.split(",");
        int i = 0;
        String currentHeader = null;
        for (String currentAttribute : attributesUnformated){
            currentHeader = getHeader(i);
            attributes.add(new DataAttribute(currentHeader, currentAttribute));
            i++;
        }
        return attributes;
    }

    private String getHeader(int position){
        if(header == null)
            setHeaderDataLine();
            if(position < header.length)
        return header[position];
            return "";
    }

    private T createEmptyInstance() {
        try{
            return (T) classInfo.newInstance();
        } catch (Exception e){
            return null;
        }
    }

    private List<Method> getClassAnnotatedSetters(){
        List<Method> classSetters = new ArrayList<>();
        List<Method> classMethods =  Arrays.stream(classInfo.getMethods()).collect(Collectors.toList());
        for (Method method : classMethods){
            CsvAttributeSetter annotation = getAttributeSetter(method);
            if(annotation != null)
                classSetters.add(method);
        }
        return classSetters;
    }

    // todo: How to simplify this method?
    private void invokeSetter(Object instance, Method setter, CsvAttributeSetter attributeSetter, List<DataAttribute> attributes){
        try{
            Object value = null;
            Optional<Class<?>> optionalClass = Arrays.stream(setter.getParameterTypes()).findFirst();
            Class type = null;
            if(optionalClass.isPresent())
                type = optionalClass.get();
            else
                return;

            if(type.equals(String.class)){
                value = getStringDataFromAttributeOrNull(attributes, attributeSetter.attributeName());
            } else if(type.equals(double.class)){
                value = getDoubleDataFromAttributeOrNull(attributes, attributeSetter.attributeName());
            } else if(type.equals(LocalDate.class))
                value = getLocalDateDataFromAttributeOrNull(attributes, attributeSetter.attributeName());
            else if(type.equals(int.class)){
                value = getIntDataFromAttributeOrNull(attributes, attributeSetter.attributeName());
            }
            if(value!= null)
                setter.invoke(instance, value);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private CsvAttributeSetter getAttributeSetter(Method method){
        return method.getAnnotation(CsvAttributeSetter.class);
    }

    // todo:separete the value geting from value parsing
    private String getStringDataFromAttributeOrNull(List<DataAttribute> attributes, String attributeName){
        Optional<DataAttribute> attribute = attributes.stream().filter(p->p.getAttribute().equals(attributeName)).findFirst();
        if(attribute.isPresent())
            return attribute.get().getData();
        return null;
    }

    private double getDoubleDataFromAttributeOrNull(List<DataAttribute> attributes, String attributeName){
        String data = getStringDataFromAttributeOrNull(attributes, attributeName);
        if(data == null || data.equals(""))
            return 0;
        return Double.parseDouble(data);
    }

    private int getIntDataFromAttributeOrNull(List<DataAttribute> attributes, String attributeName){
        String data = getStringDataFromAttributeOrNull(attributes, attributeName);
        if(data == null || data.equals(""))
            return 0;
        return Integer.parseInt(data);
    }

    private LocalDate getLocalDateDataFromAttributeOrNull(List<DataAttribute> attributes, String attributeName){
        String data = getStringDataFromAttributeOrNull(attributes, attributeName);
        if(data == null || data.equals(""))
            return null;
        return LocalDate.parse(data);
    }
}
