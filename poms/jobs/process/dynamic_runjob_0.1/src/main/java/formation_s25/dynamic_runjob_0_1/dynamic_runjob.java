// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package formation_s25.dynamic_runjob_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: dynamic_runjob Purpose: exécuter plusieurs jobs différent avec le même
 * runjob<br>
 * Description: le nom du job est une variable <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class dynamic_runjob implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "dynamic_runjob";
	private final String projectName = "FORMATION_S25";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					dynamic_runjob.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(dynamic_runjob.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFileList_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tReplace_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFlowToIterate_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tIterateToFlow_1_ITFO_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tIterateToFlow_1_AI_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileList_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tIterateToFlow_1_AI_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class OnSubjobOkStructtIterateToFlow_1
			implements routines.system.IPersistableRow<OnSubjobOkStructtIterateToFlow_1> {
		final static byte[] commonByteArrayLock_FORMATION_S25_dynamic_runjob = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_dynamic_runjob = new byte[0];

		public String filename;

		public String getFilename() {
			return this.filename;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_dynamic_runjob.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_dynamic_runjob.length == 0) {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_dynamic_runjob.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_dynamic_runjob.length == 0) {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_dynamic_runjob) {

				try {

					int length = 0;

					this.filename = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_dynamic_runjob) {

				try {

					int length = 0;

					this.filename = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.filename, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.filename, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("filename=" + filename);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(OnSubjobOkStructtIterateToFlow_1 other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileList_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileList_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;
		String currentVirtualComponent = null;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tFileList_1 begin ] start
				 */

				int NB_ITERATE_tIterateToFlow_1_ITFO = 0; // for statistics

				ok_Hash.put("tFileList_1", false);
				start_Hash.put("tFileList_1", System.currentTimeMillis());

				currentComponent = "tFileList_1";

				int tos_count_tFileList_1 = 0;

				String directory_tFileList_1 = "C:/talend/TOS_DI-20211109_1610-V8.0.1/workspace/" + projectName
						+ "/process";
				final java.util.List<String> maskList_tFileList_1 = new java.util.ArrayList<String>();
				final java.util.List<java.util.regex.Pattern> patternList_tFileList_1 = new java.util.ArrayList<java.util.regex.Pattern>();
				maskList_tFileList_1.add("a*.item");
				for (final String filemask_tFileList_1 : maskList_tFileList_1) {
					String filemask_compile_tFileList_1 = filemask_tFileList_1;

					filemask_compile_tFileList_1 = org.apache.oro.text.GlobCompiler.globToPerl5(
							filemask_tFileList_1.toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);

					java.util.regex.Pattern fileNamePattern_tFileList_1 = java.util.regex.Pattern
							.compile(filemask_compile_tFileList_1);
					patternList_tFileList_1.add(fileNamePattern_tFileList_1);
				}
				int NB_FILEtFileList_1 = 0;

				final boolean case_sensitive_tFileList_1 = true;

				final java.util.List<java.io.File> list_tFileList_1 = new java.util.ArrayList<java.io.File>();
				final java.util.Set<String> filePath_tFileList_1 = new java.util.HashSet<String>();
				java.io.File file_tFileList_1 = new java.io.File(directory_tFileList_1);

				file_tFileList_1.listFiles(new java.io.FilenameFilter() {
					public boolean accept(java.io.File dir, String name) {
						java.io.File file = new java.io.File(dir, name);

						if (!file.isDirectory()) {

							String fileName_tFileList_1 = file.getName();
							for (final java.util.regex.Pattern fileNamePattern_tFileList_1 : patternList_tFileList_1) {
								if (fileNamePattern_tFileList_1.matcher(fileName_tFileList_1).matches()) {
									if (!filePath_tFileList_1.contains(file.getAbsolutePath())) {
										list_tFileList_1.add(file);
										filePath_tFileList_1.add(file.getAbsolutePath());
									}
								}
							}
							return true;
						} else {
							file.listFiles(this);
						}

						return false;
					}
				});
				java.util.Collections.sort(list_tFileList_1);

				for (int i_tFileList_1 = 0; i_tFileList_1 < list_tFileList_1.size(); i_tFileList_1++) {
					java.io.File files_tFileList_1 = list_tFileList_1.get(i_tFileList_1);
					String fileName_tFileList_1 = files_tFileList_1.getName();

					String currentFileName_tFileList_1 = files_tFileList_1.getName();
					String currentFilePath_tFileList_1 = files_tFileList_1.getAbsolutePath();
					String currentFileDirectory_tFileList_1 = files_tFileList_1.getParent();
					String currentFileExtension_tFileList_1 = null;

					if (files_tFileList_1.getName().contains(".") && files_tFileList_1.isFile()) {
						currentFileExtension_tFileList_1 = files_tFileList_1.getName()
								.substring(files_tFileList_1.getName().lastIndexOf(".") + 1);
					} else {
						currentFileExtension_tFileList_1 = "";
					}

					NB_FILEtFileList_1++;
					globalMap.put("tFileList_1_CURRENT_FILE", currentFileName_tFileList_1);
					globalMap.put("tFileList_1_CURRENT_FILEPATH", currentFilePath_tFileList_1);
					globalMap.put("tFileList_1_CURRENT_FILEDIRECTORY", currentFileDirectory_tFileList_1);
					globalMap.put("tFileList_1_CURRENT_FILEEXTENSION", currentFileExtension_tFileList_1);
					globalMap.put("tFileList_1_NB_FILE", NB_FILEtFileList_1);

					/**
					 * [tFileList_1 begin ] stop
					 */

					/**
					 * [tFileList_1 main ] start
					 */

					currentComponent = "tFileList_1";

					tos_count_tFileList_1++;

					/**
					 * [tFileList_1 main ] stop
					 */

					/**
					 * [tFileList_1 process_data_begin ] start
					 */

					currentComponent = "tFileList_1";

					/**
					 * [tFileList_1 process_data_begin ] stop
					 */
					NB_ITERATE_tIterateToFlow_1_ITFO++;

					if (execStat) {
						runStat.updateStatOnConnection("iterate1", 1, "exec" + NB_ITERATE_tIterateToFlow_1_ITFO);
						// Thread.sleep(1000);
					}

					/**
					 * [tIterateToFlow_1_ITFO begin ] start
					 */

					ok_Hash.put("tIterateToFlow_1_ITFO", false);
					start_Hash.put("tIterateToFlow_1_ITFO", System.currentTimeMillis());

					currentVirtualComponent = "tIterateToFlow_1";

					currentComponent = "tIterateToFlow_1_ITFO";

					int tos_count_tIterateToFlow_1_ITFO = 0;

					OnSubjobOkStructtIterateToFlow_1 struct_tIterateToFlow_1_ITFO = new OnSubjobOkStructtIterateToFlow_1();
					struct_tIterateToFlow_1_ITFO.filename = ((String) globalMap.get("tFileList_1_CURRENT_FILE"));

					if (globalMap.get("tIterateToFlow_1") != null) {
						java.util.List<OnSubjobOkStructtIterateToFlow_1> list_tIterateToFlow_1_ITFO = (java.util.List<OnSubjobOkStructtIterateToFlow_1>) globalMap
								.get("tIterateToFlow_1");
						list_tIterateToFlow_1_ITFO.add(struct_tIterateToFlow_1_ITFO);
					} else {
						java.util.List<OnSubjobOkStructtIterateToFlow_1> list_tIterateToFlow_1_ITFO = new java.util.ArrayList<OnSubjobOkStructtIterateToFlow_1>();
						list_tIterateToFlow_1_ITFO.add(struct_tIterateToFlow_1_ITFO);
						globalMap.put("tIterateToFlow_1", list_tIterateToFlow_1_ITFO);
					}

					/**
					 * [tIterateToFlow_1_ITFO begin ] stop
					 */

					/**
					 * [tIterateToFlow_1_ITFO main ] start
					 */

					currentVirtualComponent = "tIterateToFlow_1";

					currentComponent = "tIterateToFlow_1_ITFO";

					tos_count_tIterateToFlow_1_ITFO++;

					/**
					 * [tIterateToFlow_1_ITFO main ] stop
					 */

					/**
					 * [tIterateToFlow_1_ITFO process_data_begin ] start
					 */

					currentVirtualComponent = "tIterateToFlow_1";

					currentComponent = "tIterateToFlow_1_ITFO";

					/**
					 * [tIterateToFlow_1_ITFO process_data_begin ] stop
					 */

					/**
					 * [tIterateToFlow_1_ITFO process_data_end ] start
					 */

					currentVirtualComponent = "tIterateToFlow_1";

					currentComponent = "tIterateToFlow_1_ITFO";

					/**
					 * [tIterateToFlow_1_ITFO process_data_end ] stop
					 */

					/**
					 * [tIterateToFlow_1_ITFO end ] start
					 */

					currentVirtualComponent = "tIterateToFlow_1";

					currentComponent = "tIterateToFlow_1_ITFO";

					ok_Hash.put("tIterateToFlow_1_ITFO", true);
					end_Hash.put("tIterateToFlow_1_ITFO", System.currentTimeMillis());

					/**
					 * [tIterateToFlow_1_ITFO end ] stop
					 */
					if (execStat) {
						runStat.updateStatOnConnection("iterate1", 2, "exec" + NB_ITERATE_tIterateToFlow_1_ITFO);
					}

					/**
					 * [tFileList_1 process_data_end ] start
					 */

					currentComponent = "tFileList_1";

					/**
					 * [tFileList_1 process_data_end ] stop
					 */

					/**
					 * [tFileList_1 end ] start
					 */

					currentComponent = "tFileList_1";

				}
				globalMap.put("tFileList_1_NB_FILE", NB_FILEtFileList_1);

				ok_Hash.put("tFileList_1", true);
				end_Hash.put("tFileList_1", System.currentTimeMillis());

				/**
				 * [tFileList_1 end ] stop
				 */
			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFileList_1:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk", 0, "ok");
			}

			tIterateToFlow_1_AIProcess(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFileList_1 finally ] start
				 */

				currentComponent = "tFileList_1";

				/**
				 * [tFileList_1 finally ] stop
				 */

				/**
				 * [tIterateToFlow_1_ITFO finally ] start
				 */

				currentVirtualComponent = "tIterateToFlow_1";

				currentComponent = "tIterateToFlow_1_ITFO";

				/**
				 * [tIterateToFlow_1_ITFO finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileList_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_FORMATION_S25_dynamic_runjob = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_dynamic_runjob = new byte[0];

		public String filename;

		public String getFilename() {
			return this.filename;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_dynamic_runjob.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_dynamic_runjob.length == 0) {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_dynamic_runjob.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_dynamic_runjob.length == 0) {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_dynamic_runjob) {

				try {

					int length = 0;

					this.filename = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_dynamic_runjob) {

				try {

					int length = 0;

					this.filename = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.filename, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.filename, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("filename=" + filename);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_FORMATION_S25_dynamic_runjob = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_dynamic_runjob = new byte[0];

		public String filename;

		public String getFilename() {
			return this.filename;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_dynamic_runjob.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_dynamic_runjob.length == 0) {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_dynamic_runjob.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_dynamic_runjob.length == 0) {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_dynamic_runjob = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_dynamic_runjob, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_dynamic_runjob) {

				try {

					int length = 0;

					this.filename = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_dynamic_runjob) {

				try {

					int length = 0;

					this.filename = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.filename, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.filename, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("filename=" + filename);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tIterateToFlow_1_AIProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tIterateToFlow_1_AI_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;
		String currentVirtualComponent = null;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();
				row2Struct row2 = new row2Struct();

				/**
				 * [tFlowToIterate_1 begin ] start
				 */

				int NB_ITERATE_tRunJob_1 = 0; // for statistics

				ok_Hash.put("tFlowToIterate_1", false);
				start_Hash.put("tFlowToIterate_1", System.currentTimeMillis());

				currentComponent = "tFlowToIterate_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tFlowToIterate_1 = 0;

				int nb_line_tFlowToIterate_1 = 0;
				int counter_tFlowToIterate_1 = 0;

				/**
				 * [tFlowToIterate_1 begin ] stop
				 */

				/**
				 * [tReplace_1 begin ] start
				 */

				ok_Hash.put("tReplace_1", false);
				start_Hash.put("tReplace_1", System.currentTimeMillis());

				currentComponent = "tReplace_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tReplace_1 = 0;

				int nb_line_tReplace_1 = 0;

				/**
				 * [tReplace_1 begin ] stop
				 */

				/**
				 * [tIterateToFlow_1_AI begin ] start
				 */

				ok_Hash.put("tIterateToFlow_1_AI", false);
				start_Hash.put("tIterateToFlow_1_AI", System.currentTimeMillis());

				currentVirtualComponent = "tIterateToFlow_1";

				currentComponent = "tIterateToFlow_1_AI";

				int tos_count_tIterateToFlow_1_AI = 0;

				int nb_line_tIterateToFlow_1_AI = 0;
				java.util.List<OnSubjobOkStructtIterateToFlow_1> list_tIterateToFlow_1_AI = (java.util.List<OnSubjobOkStructtIterateToFlow_1>) globalMap
						.get("tIterateToFlow_1");
				if (list_tIterateToFlow_1_AI == null) {
					list_tIterateToFlow_1_AI = new java.util.ArrayList<OnSubjobOkStructtIterateToFlow_1>();
				}
				for (OnSubjobOkStructtIterateToFlow_1 row_tIterateToFlow_1_AI : list_tIterateToFlow_1_AI) {

					row1.filename = row_tIterateToFlow_1_AI.filename;

					/**
					 * [tIterateToFlow_1_AI begin ] stop
					 */

					/**
					 * [tIterateToFlow_1_AI main ] start
					 */

					currentVirtualComponent = "tIterateToFlow_1";

					currentComponent = "tIterateToFlow_1_AI";

					tos_count_tIterateToFlow_1_AI++;

					/**
					 * [tIterateToFlow_1_AI main ] stop
					 */

					/**
					 * [tIterateToFlow_1_AI process_data_begin ] start
					 */

					currentVirtualComponent = "tIterateToFlow_1";

					currentComponent = "tIterateToFlow_1_AI";

					/**
					 * [tIterateToFlow_1_AI process_data_begin ] stop
					 */

					/**
					 * [tReplace_1 main ] start
					 */

					currentComponent = "tReplace_1";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row1"

						);
					}

					row1.filename = StringUtils.replaceAll(row1.filename, "_[0-9]\\.[0-9]\\.item", "" + "");
					row2.filename = row1.filename;

					nb_line_tReplace_1++;

					tos_count_tReplace_1++;

					/**
					 * [tReplace_1 main ] stop
					 */

					/**
					 * [tReplace_1 process_data_begin ] start
					 */

					currentComponent = "tReplace_1";

					/**
					 * [tReplace_1 process_data_begin ] stop
					 */

					/**
					 * [tFlowToIterate_1 main ] start
					 */

					currentComponent = "tFlowToIterate_1";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row2"

						);
					}

					globalMap.put("row2.filename", row2.filename);

					nb_line_tFlowToIterate_1++;
					counter_tFlowToIterate_1++;
					globalMap.put("tFlowToIterate_1_CURRENT_ITERATION", counter_tFlowToIterate_1);

					tos_count_tFlowToIterate_1++;

					/**
					 * [tFlowToIterate_1 main ] stop
					 */

					/**
					 * [tFlowToIterate_1 process_data_begin ] start
					 */

					currentComponent = "tFlowToIterate_1";

					/**
					 * [tFlowToIterate_1 process_data_begin ] stop
					 */
					NB_ITERATE_tRunJob_1++;

					if (execStat) {
						runStat.updateStatOnConnection("iterate2", 1, "exec" + NB_ITERATE_tRunJob_1);
						// Thread.sleep(1000);
					}

					/**
					 * [tRunJob_1 begin ] start
					 */

					ok_Hash.put("tRunJob_1", false);
					start_Hash.put("tRunJob_1", System.currentTimeMillis());

					currentComponent = "tRunJob_1";

					int tos_count_tRunJob_1 = 0;

					class DealChildJobLibrary_tRunJob_1 {

						public String replaceJarPathsFromCrcMap(String originalClassPathLine)
								throws java.lang.Exception {
							String classPathLine = "";
							String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
							if (isNeedAddLibsPath(crcMapPath)) {
								java.util.Map<String, String> crcMap = null;
								java.io.ObjectInputStream ois = new java.io.ObjectInputStream(
										new java.io.FileInputStream(crcMapPath)) {
									@Override
									public Class<?> resolveClass(java.io.ObjectStreamClass desc)
											throws java.io.IOException, ClassNotFoundException {
										if (!"java.util.HashMap".equals(desc.getName())) {
											throw new java.io.InvalidClassException(
													"Unauthorized deserialization attempt : " + desc.getName());
										}
										return super.resolveClass(desc);
									}
								};
								crcMap = (java.util.Map<String, String>) ois.readObject();
								ois.close();
								classPathLine = addLibsPath(originalClassPathLine, crcMap);
							} else {
								classPathLine = originalClassPathLine;
							}
							return classPathLine;
						}

						private boolean isNeedAddLibsPath(String crcMapPath) {
							if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
								return false;
							}
							return true;
						}

						private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
							for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
								line = adaptLibPaths(line, entry);
							}
							return line;
						}

						private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
							String jarName = entry.getValue();
							String crc = entry.getKey();
							String libStringFinder = "../lib/" + jarName;
							if (line.contains(libStringFinder)) {
								line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
							} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
								line = line.replace(":$ROOT_PATH/" + jarName + ":",
										":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
							} else if (line.contains(";" + jarName + ";")) {
								line = line.replace(";" + jarName + ";",
										";../../../cache/lib/" + crc + "/" + jarName + ";");
							}
							return line;
						}

					}
					DealChildJobLibrary_tRunJob_1 dealChildJobLibrary_tRunJob_1 = new DealChildJobLibrary_tRunJob_1();

					class JVMArgumentHelper_tRunJob_1 {

						private void addClasspath(java.util.List<String> target_argument_list,
								String job_origin_classpath) {

							String extra_classpath = null;
							String path_separator = System.getProperty("path.separator");
							if (path_separator != null && path_separator.length() > 1) {
								throw new RuntimeException("path separator should be single character");
							}

							if (extra_classpath != null && !extra_classpath.isEmpty()) {
								if (extra_classpath.endsWith(path_separator)) {
									target_argument_list.add(extra_classpath + job_origin_classpath);
								} else if (extra_classpath.contains(path_separator)) {
									target_argument_list
											.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
								} else if (extra_classpath.endsWith(":")) {
									target_argument_list
											.add(extra_classpath.replace(":", path_separator) + job_origin_classpath);
								} else if (extra_classpath.endsWith(";")) {
									target_argument_list
											.add(extra_classpath.replace(";", path_separator) + job_origin_classpath);
								} else if (extra_classpath.contains(":")) {
									target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator),
											path_separator, job_origin_classpath));
								} else if (extra_classpath.contains(";")) {
									target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator),
											path_separator, job_origin_classpath));
								} else {
									target_argument_list
											.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
								}
								return;
							}

							target_argument_list.add(job_origin_classpath);
						}

						private String concatStr(String s1, String s2, String s3) {
							java.lang.StringBuilder strB = new java.lang.StringBuilder();
							strB.append(s1).append(s2).append(s3);
							return strB.toString();
						}

						public void addArgumentsTo(java.util.List<String> target_argument_list,
								String argument_from_child) {
							addArgumentsTo(target_argument_list, argument_from_child, false);
						}

						public void addArgumentsTo(java.util.List<String> target_argument_list,
								String argument_from_child, boolean isCP) {
							if (isCP) {
								addClasspath(target_argument_list, argument_from_child);
								return;
							}

							target_argument_list.add(argument_from_child);

						}

					}

					JVMArgumentHelper_tRunJob_1 jvm_argument_helper_tRunJob_1 = new JVMArgumentHelper_tRunJob_1();

					String audit_jar_path_tRunJob_1 = System.getProperty("classpath.extended");

					// For different jobs, job name must be different, but classpath and JVM
					// arguments are possbilely different
					java.util.Map<String, List<String>> childJob_commandLine_Mapper_tRunJob_1 = new java.util.HashMap<String, List<String>>();
					java.util.List<String> childJob_commandLine_tRunJob_1 = null;
					String classpathSeparator_tRunJob_1 = System.getProperty("path.separator");
					if (classpathSeparator_tRunJob_1 != null && classpathSeparator_tRunJob_1.length() > 1) {
						throw new RuntimeException("path separator should be single character");
					}

					childJob_commandLine_tRunJob_1 = new java.util.ArrayList<String>();

					childJob_commandLine_tRunJob_1.add("C:/Program Files/Java/jdk-17.0.2/bin/java.exe");

					final java.util.List<String> cc_tRunJob_1_0 = childJob_commandLine_tRunJob_1;
					if (enableLogStash) {
						System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit."))
								.forEach(key -> cc_tRunJob_1_0.add("-D" + key + "=" + System.getProperty(key)));
					}

					System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> cc_tRunJob_1_0.add("-D" + key + "=" + System.getProperty(key)));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Xms256M".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Xmx1024M".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Dfile.encoding=UTF-8".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Dtalend.component.manager.m2.repository=C:/talend/TOS_DI-20211109_1610-V8.0.1/configuration/.m2/repository"
									.replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-cp".replaceAll(";", classpathSeparator_tRunJob_1));

					String classpath_tRunJob_1_0_6 = "C:/talend/TOS_DI-20211109_1610-V8.0.1/workspace/FORMATION_S25/poms/jobs/process/advanced/advanced_lookup_0.1/target/classpath.jar;";

					if (audit_jar_path_tRunJob_1 != null && !audit_jar_path_tRunJob_1.isEmpty()) {
						classpath_tRunJob_1_0_6 += audit_jar_path_tRunJob_1;
					}

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(classpath_tRunJob_1_0_6)
									.replaceAll(";", classpathSeparator_tRunJob_1),
							true);

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"formation_s25.advanced_lookup_0_1.advanced_lookup".replaceAll(";",
									classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--father_pid=" + pid.replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--root_pid=" + rootPid.replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--father_node=tRunJob_1".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--context=Default".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"%*".replaceAll(";", classpathSeparator_tRunJob_1));

					childJob_commandLine_Mapper_tRunJob_1.put("advanced_lookup", childJob_commandLine_tRunJob_1);

					childJob_commandLine_tRunJob_1 = new java.util.ArrayList<String>();

					childJob_commandLine_tRunJob_1.add("C:/Program Files/Java/jdk-17.0.2/bin/java.exe");

					final java.util.List<String> cc_tRunJob_1_1 = childJob_commandLine_tRunJob_1;
					if (enableLogStash) {
						System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit."))
								.forEach(key -> cc_tRunJob_1_1.add("-D" + key + "=" + System.getProperty(key)));
					}

					System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> cc_tRunJob_1_1.add("-D" + key + "=" + System.getProperty(key)));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Xms256M".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Xmx1024M".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Dfile.encoding=UTF-8".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Dtalend.component.manager.m2.repository=C:/talend/TOS_DI-20211109_1610-V8.0.1/configuration/.m2/repository"
									.replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-cp".replaceAll(";", classpathSeparator_tRunJob_1));

					String classpath_tRunJob_1_1_6 = "C:/talend/TOS_DI-20211109_1610-V8.0.1/workspace/FORMATION_S25/poms/jobs/process/advanced/advanced_tmap_0.1/target/classpath.jar;";

					if (audit_jar_path_tRunJob_1 != null && !audit_jar_path_tRunJob_1.isEmpty()) {
						classpath_tRunJob_1_1_6 += audit_jar_path_tRunJob_1;
					}

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(classpath_tRunJob_1_1_6)
									.replaceAll(";", classpathSeparator_tRunJob_1),
							true);

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"formation_s25.advanced_tmap_0_1.advanced_tmap".replaceAll(";",
									classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--father_pid=" + pid.replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--root_pid=" + rootPid.replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--father_node=tRunJob_1".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--context=Default".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"%*".replaceAll(";", classpathSeparator_tRunJob_1));

					childJob_commandLine_Mapper_tRunJob_1.put("advanced_tmap", childJob_commandLine_tRunJob_1);

					childJob_commandLine_tRunJob_1 = new java.util.ArrayList<String>();

					childJob_commandLine_tRunJob_1.add("C:/Program Files/Java/jdk-17.0.2/bin/java.exe");

					final java.util.List<String> cc_tRunJob_1_2 = childJob_commandLine_tRunJob_1;
					if (enableLogStash) {
						System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit."))
								.forEach(key -> cc_tRunJob_1_2.add("-D" + key + "=" + System.getProperty(key)));
					}

					System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> cc_tRunJob_1_2.add("-D" + key + "=" + System.getProperty(key)));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Xms256M".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Xmx1024M".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Dfile.encoding=UTF-8".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-Dtalend.component.manager.m2.repository=C:/talend/TOS_DI-20211109_1610-V8.0.1/configuration/.m2/repository"
									.replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"-cp".replaceAll(";", classpathSeparator_tRunJob_1));

					String classpath_tRunJob_1_2_6 = "C:/talend/TOS_DI-20211109_1610-V8.0.1/workspace/FORMATION_S25/poms/jobs/process/api_multithreading_0.1/target/classpath.jar;";

					if (audit_jar_path_tRunJob_1 != null && !audit_jar_path_tRunJob_1.isEmpty()) {
						classpath_tRunJob_1_2_6 += audit_jar_path_tRunJob_1;
					}

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(classpath_tRunJob_1_2_6)
									.replaceAll(";", classpathSeparator_tRunJob_1),
							true);

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"formation_s25.api_multithreading_0_1.api_multithreading".replaceAll(";",
									classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--father_pid=" + pid.replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--root_pid=" + rootPid.replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--father_node=tRunJob_1".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"--context=Default".replaceAll(";", classpathSeparator_tRunJob_1));

					jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1,
							"%*".replaceAll(";", classpathSeparator_tRunJob_1));

					childJob_commandLine_Mapper_tRunJob_1.put("api_multithreading", childJob_commandLine_tRunJob_1);

					/**
					 * [tRunJob_1 begin ] stop
					 */

					/**
					 * [tRunJob_1 main ] start
					 */

					currentComponent = "tRunJob_1";

					java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();

					if (childJob_commandLine_Mapper_tRunJob_1.get(((String) globalMap.get("row2.filename"))) == null) {
						throw new RuntimeException("The child job named " + ((String) globalMap.get("row2.filename"))
								+ " is not in the job list.");
					}
					paraList_tRunJob_1.addAll(
							childJob_commandLine_Mapper_tRunJob_1.get(((String) globalMap.get("row2.filename"))));

					// for feature:10589

					paraList_tRunJob_1.add("--stat_port=" + null);

					if (resuming_logs_dir_path != null) {
						paraList_tRunJob_1.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
					}
					String childResumePath_tRunJob_1 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
					String tRunJobName_tRunJob_1 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
					if ("tRunJob_1".equals(tRunJobName_tRunJob_1) && childResumePath_tRunJob_1 != null) {
						paraList_tRunJob_1.add("--resuming_checkpoint_path="
								+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
					}
					paraList_tRunJob_1.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_1");

					java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

					Object obj_tRunJob_1 = null;

					class ConsoleHelper_tRunJob_1 {
						private Thread getNormalThread(Process process) {
							return new Thread() {
								public void run() {
									try {
										java.io.BufferedReader reader = new java.io.BufferedReader(
												new java.io.InputStreamReader(process.getInputStream()));
										String line = "";
										try {
											while ((line = reader.readLine()) != null) {
												System.out.println(line);
											}
										} finally {
											reader.close();
										}
									} catch (java.io.IOException ioe) {
										globalMap.put("tRunJob_1_ERROR_MESSAGE", ioe.getMessage());

										ioe.printStackTrace();
									}
								}
							};
						}

						private Thread getErrorThread(Process process, StringBuffer sb) {
							return new Thread() {
								public void run() {
									try {
										java.io.BufferedReader reader = new java.io.BufferedReader(
												new java.io.InputStreamReader(process.getErrorStream()));
										String line = "";
										try {
											while ((line = reader.readLine()) != null) {
												sb.append(line).append("\n");
											}
										} finally {
											reader.close();
										}
									} catch (java.io.IOException ioe) {
										globalMap.put("tRunJob_1_ERROR_MESSAGE", ioe.getMessage());

										ioe.printStackTrace();
									}
								}
							};
						}
					}
					ConsoleHelper_tRunJob_1 consoleHelper_tRunJob_1 = new ConsoleHelper_tRunJob_1();

					Runtime runtime_tRunJob_1 = Runtime.getRuntime();
					Process ps_tRunJob_1 = null;

					// 0 indicates normal termination
					int result_tRunJob_1;
					StringBuffer errorMsg_tRunJob_1 = new StringBuffer();
					try {
						ps_tRunJob_1 = runtime_tRunJob_1
								.exec((String[]) paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));

						Thread normal_tRunJob_1 = consoleHelper_tRunJob_1.getNormalThread(ps_tRunJob_1);
						normal_tRunJob_1.start();

						Thread error_tRunJob_1 = consoleHelper_tRunJob_1.getErrorThread(ps_tRunJob_1,
								errorMsg_tRunJob_1);
						error_tRunJob_1.start();

						result_tRunJob_1 = ps_tRunJob_1.waitFor();
						normal_tRunJob_1.join();
						error_tRunJob_1.join();
					} catch (ThreadDeath tde) {
						globalMap.put("tRunJob_1_ERROR_MESSAGE", tde.getMessage());
						ps_tRunJob_1.destroy();
						throw tde;
					}

					globalMap.put("tRunJob_1_CHILD_RETURN_CODE", result_tRunJob_1);
					if (result_tRunJob_1 != 0) {
						globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE", errorMsg_tRunJob_1.toString());

						throw new RuntimeException("Child job returns " + result_tRunJob_1
								+ ". It doesn't terminate normally.\n" + errorMsg_tRunJob_1.toString());

					}

					tos_count_tRunJob_1++;

					/**
					 * [tRunJob_1 main ] stop
					 */

					/**
					 * [tRunJob_1 process_data_begin ] start
					 */

					currentComponent = "tRunJob_1";

					/**
					 * [tRunJob_1 process_data_begin ] stop
					 */

					/**
					 * [tRunJob_1 process_data_end ] start
					 */

					currentComponent = "tRunJob_1";

					/**
					 * [tRunJob_1 process_data_end ] stop
					 */

					/**
					 * [tRunJob_1 end ] start
					 */

					currentComponent = "tRunJob_1";

					ok_Hash.put("tRunJob_1", true);
					end_Hash.put("tRunJob_1", System.currentTimeMillis());

					/**
					 * [tRunJob_1 end ] stop
					 */
					if (execStat) {
						runStat.updateStatOnConnection("iterate2", 2, "exec" + NB_ITERATE_tRunJob_1);
					}

					/**
					 * [tFlowToIterate_1 process_data_end ] start
					 */

					currentComponent = "tFlowToIterate_1";

					/**
					 * [tFlowToIterate_1 process_data_end ] stop
					 */

					/**
					 * [tReplace_1 process_data_end ] start
					 */

					currentComponent = "tReplace_1";

					/**
					 * [tReplace_1 process_data_end ] stop
					 */

					/**
					 * [tIterateToFlow_1_AI process_data_end ] start
					 */

					currentVirtualComponent = "tIterateToFlow_1";

					currentComponent = "tIterateToFlow_1_AI";

					/**
					 * [tIterateToFlow_1_AI process_data_end ] stop
					 */

					/**
					 * [tIterateToFlow_1_AI end ] start
					 */

					currentVirtualComponent = "tIterateToFlow_1";

					currentComponent = "tIterateToFlow_1_AI";

					nb_line_tIterateToFlow_1_AI++;
				}
				globalMap.put("tIterateToFlow_1_AI_NB_LINE", nb_line_tIterateToFlow_1_AI);

				ok_Hash.put("tIterateToFlow_1_AI", true);
				end_Hash.put("tIterateToFlow_1_AI", System.currentTimeMillis());

				/**
				 * [tIterateToFlow_1_AI end ] stop
				 */

				/**
				 * [tReplace_1 end ] start
				 */

				currentComponent = "tReplace_1";

				globalMap.put("tReplace_1_NB_LINE", nb_line_tReplace_1);
				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tReplace_1", true);
				end_Hash.put("tReplace_1", System.currentTimeMillis());

				/**
				 * [tReplace_1 end ] stop
				 */

				/**
				 * [tFlowToIterate_1 end ] start
				 */

				currentComponent = "tFlowToIterate_1";

				globalMap.put("tFlowToIterate_1_NB_LINE", nb_line_tFlowToIterate_1);
				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tFlowToIterate_1", true);
				end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());

				/**
				 * [tFlowToIterate_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tIterateToFlow_1_AI"
			globalMap.remove("tIterateToFlow_1");

			try {

				/**
				 * [tIterateToFlow_1_AI finally ] start
				 */

				currentVirtualComponent = "tIterateToFlow_1";

				currentComponent = "tIterateToFlow_1_AI";

				/**
				 * [tIterateToFlow_1_AI finally ] stop
				 */

				/**
				 * [tReplace_1 finally ] start
				 */

				currentComponent = "tReplace_1";

				/**
				 * [tReplace_1 finally ] stop
				 */

				/**
				 * [tFlowToIterate_1 finally ] start
				 */

				currentComponent = "tFlowToIterate_1";

				/**
				 * [tFlowToIterate_1 finally ] stop
				 */

				/**
				 * [tRunJob_1 finally ] start
				 */

				currentComponent = "tRunJob_1";

				/**
				 * [tRunJob_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tIterateToFlow_1_AI_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final dynamic_runjob dynamic_runjobClass = new dynamic_runjob();

		int exitCode = dynamic_runjobClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = dynamic_runjob.class.getClassLoader()
					.getResourceAsStream("formation_s25/dynamic_runjob_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = dynamic_runjob.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFileList_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileList_1) {
			globalMap.put("tFileList_1_SUBPROCESS_STATE", -1);

			e_tFileList_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : dynamic_runjob");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 79503 characters generated by Talend Open Studio for Data Integration on the
 * 24 juin 2022 à 16:53:43 CEST
 ************************************************************************************************/