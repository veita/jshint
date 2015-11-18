/*
 * (C) Copyright 2015 Alexander Veit
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


package org.jshint.nashorn;


import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import junit.framework.TestCase;


/**
 * @author veita
 */
public final class NashornTestCase extends TestCase
{
	public void testEvalJsHint() throws Exception
	{
		final Path         l_fileJsHInt;
		final ScriptEngine l_engine;

		l_fileJsHInt = Paths.get("dist/jshint.js");

		assertTrue("File dist/jshint.js not found.", Files.isRegularFile(l_fileJsHInt));

		l_engine = new ScriptEngineManager().getEngineByName("nashorn");

		try (final Reader l_in = Files.newBufferedReader(l_fileJsHInt, StandardCharsets.UTF_8))
		{
			l_engine.eval(l_in);
		}
	}
}
