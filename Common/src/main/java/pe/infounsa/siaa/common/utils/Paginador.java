package pe.infounsa.siaa.common.utils;

import javax.servlet.http.HttpServletRequest;

public class Paginador {
	private static String STARTINDEX = "pagina";
	private static String PAGESIZE = "cantidad";
	private int startIndex;
	private int pageSize;

	public Paginador(int startIndex, int pageSize) {
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Integer calcularPaginacion(Integer pagina, Integer limite){
		
		Integer pag = (pagina - 1);
		Integer paginacion = 0;
		
		if(pag>0)
			paginacion = pag * limite; 
		
		return paginacion;
		
	}
	public static Paginador getPagination(HttpServletRequest context){
		Integer start = getIntegerFromServletRequest(context, Paginador.STARTINDEX);
		Integer size = getIntegerFromServletRequest(context, Paginador.PAGESIZE);
		if(start==null|| size==null){
			return null;
		}
		return new Paginador(start,size);
	}

	private static Integer getIntegerFromServletRequest(HttpServletRequest context, String name){
		String parameter = context.getParameter(name);
		if(parameter==null || parameter.isEmpty())
			return null;
		try {
			return Integer.parseInt(parameter);
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
