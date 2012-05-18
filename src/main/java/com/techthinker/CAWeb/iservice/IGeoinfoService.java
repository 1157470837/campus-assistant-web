package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;

public interface IGeoinfoService {
	public void addGeoinfosFromInputStream(InputStream inputStream)
			throws IOException;
}
