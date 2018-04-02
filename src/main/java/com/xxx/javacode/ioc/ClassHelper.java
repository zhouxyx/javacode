package com.xxx.javacode.ioc;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassHelper {

	private static final ClassHelper bean = new ClassHelper();

	private ClassHelper() {

	}

	public  static ClassHelper getInstance() {
		return bean;
	}

	/**
	 * 加载class
	 * 
	 * @return
	 */
	public List<Class<?>> loadClassList(String packageName) {

		if (null == packageName || "".equals(packageName)) {
			throw new RuntimeException("packageName不能为空");
		}
		List<Class<?>> classList = new ArrayList<Class<?>>();
		String parentPackagePath = packageName.replaceAll("\\.", "/");
		try {
			Enumeration<URL> urls = ClassHelper.class.getClassLoader().getResources(parentPackagePath);
			String packagePath = null;
			while (urls.hasMoreElements()) {
				URL nextElement = urls.nextElement();
				packagePath = nextElement.getPath();
				addClass(classList, packagePath, packageName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return classList;
	}

	private void addClass(List<Class<?>> classList, String packagePath, String packageName) {
		try {
			File[] files = new File(packagePath).listFiles(new FileFilter() {
				@Override
				public boolean accept(File file) {
					return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
				}
			});
			for (File file : files) {
				String fileName = file.getName();

				if (file.isFile()) {
					String className = fileName.substring(0, fileName.lastIndexOf("."));
					className = packageName + "." + className;
					doAddClass(classList, className);
				} else {
					String subPackagePath = fileName;
					subPackagePath = packagePath + "/" + subPackagePath;
					String subPackageName = fileName;
					subPackageName = packageName + "." + subPackageName;
					addClass(classList, subPackagePath, subPackageName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doAddClass(List<Class<?>> classList, String className) {
		try {
			Class<?> clazz = Class.forName(className);
			classList.add(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
