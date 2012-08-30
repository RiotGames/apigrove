/**
 * Copyright © 2012 Alcatel-Lucent.
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * Licensed to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.alu.e3.installer.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;


public class LocalCommandTest {

	/* members */
	LocalCommand cmd = null;
	
	@Before
	public void setUp() throws Exception {
		 cmd = new LocalCommand();
	}

	@Test
	public void testExecShellCommand() throws Exception {
		// Dev environment (under win32) should ignore this test
		if (System.getProperty("os.name").toLowerCase().contains("win")) return;
		//
		assertNotNull(cmd);
		ShellCommandResult res = cmd.execShellCommand("echo Test");
		assertEquals(0, res.getExitStatus());
		assertEquals("Test\n", res.getResult());
	}

	@Test
	public void testCopy() throws Exception {
		assertNotNull(cmd);
		
		File fTemp = File.createTempFile("test", ".tmp");
		File fTempDest = new File(fTemp.getAbsolutePath()+".bak");
		cmd.copy(fTemp.getAbsolutePath(), fTempDest.getAbsolutePath());
		
		assertTrue(fTempDest.exists());
		fTempDest.delete();
	}

}
