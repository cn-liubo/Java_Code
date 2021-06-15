package class01;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code04_UnionFind {

	public static class Element<V> {
		public V value;

		public Element(V value) {
			this.value = value;
		}
	}

	public static class UnionFindSet<V> {
		public HashMap<V, Element<V>> elementMap;
		public HashMap<Element<V>, Element<V>> fatherMap;//key表示某个元素，value表示该元素的父结点
		public HashMap<Element<V>, Integer> sizeMap;//key表示某个集合的代表元素，value表示该集合的大小

		public UnionFindSet(List<V> list) {
			elementMap = new HashMap<>();
			fatherMap = new HashMap<>();
			sizeMap = new HashMap<>();
			for (V value : list) {
				Element<V> element = new Element<V>(value);
				elementMap.put(value, element);
				fatherMap.put(element, element);
				sizeMap.put(element, 1);
			}
		}

		//给定一个element，往上一直找，把代表元素返回
		private Element<V> findHead(Element<V> element) {
			Stack<Element<V>> path = new Stack<>();
			while (element != fatherMap.get(element)) {//当前结点不等于它的父结点一直往上走
				path.push(element);
				element = fatherMap.get(element);
			}
			//此时element指向的是代表元素的结点，返回之前将整个链变成扁平状
			while (!path.isEmpty()) {
				fatherMap.put(path.pop(), element);
			}
			return element;
		}

		public boolean isSameSet(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				return findHead(elementMap.get(a)) == findHead(elementMap.get(b));//代表元素相等才返回
			}
			return false;
		}

		public void union(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				Element<V> aF = findHead(elementMap.get(a));
				Element<V> bF = findHead(elementMap.get(b));
				if (aF != bF) {//aF和bF是两个集合的元素
					//数量较少的集合的顶端要挂在数量较多的集合的顶端的底下
					Element<V> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;//大的集合的代表结点
					Element<V> small = big == aF ? bF : aF;//小的集合的代表结点
					fatherMap.put(small, big);
					sizeMap.put(big, sizeMap.get(aF) + sizeMap.get(bF));
					sizeMap.remove(small);
				}
			}
		}

	}

}
