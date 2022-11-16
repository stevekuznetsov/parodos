/*
 * Copyright (c) 2022 Red Hat Developer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.parodos.infrastructure.option;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This is generated by the Assessment Service. It contains the information for
 * the UI to display:
 * 
 * - The tool chain the application is currently using (it might be none - meaning tooling must be created) 
 * 
 * - Any available upgrade options for the existing tool chain
 * 
 * - Existing tooling that can be created
 * 
 * - Available new tool chains that can be created for the application
 * 
 * @author Luke Shannon (Github: lshannon)
 *
 */
public class InfrastructureOptions {
	
	private InfrastructureOption currentVersion;
	private List<InfrastructureOption> upgradeOptions;
	private List<InfrastructureOption> migrationOptions;
	private List<InfrastructureOption> newOptions;
	
	public boolean isOptionsAvailable() {
		return !upgradeOptions.isEmpty() && !migrationOptions.isEmpty() && !newOptions.isEmpty();
	}
	
	public boolean hasInfrastructure() {
		return currentVersion == null;
	}
	
	public InfrastructureOption getCurrentVersion() {
		return currentVersion;
	}
	
	public void setCurrentVersion(InfrastructureOption currentVersion) {
		this.currentVersion = currentVersion;
	}
	
	// Upgrade Options
	public List<InfrastructureOption> getUpgradeOptions() {
		return upgradeOptions;
	}
	
	/**
	 * Add an Upgrade option to the existing upgrade Options
	 * 
	 * @param upgradeOption new InfrastructureOption to add to the upgrade option list
	 * @return the updated reference
	 */
	public List<InfrastructureOption> addUpgradeOption(InfrastructureOption upgradeOption) {
		upgradeOptions.add(upgradeOption);
		return upgradeOptions;
	}
	
	public void setUpgradeOptions(List<InfrastructureOption> upgradeOptions) {
		this.upgradeOptions = upgradeOptions;
	}
	
	/**
	 * Add a Migration option to the migration option list
	 * 
	 * @param migrationOption new migration option to add the migration option list
	 * @return the updated reference
	 */
	public List<InfrastructureOption> addMigrationOption(InfrastructureOption migrationOption) {
		migrationOptions.add(migrationOption);
		return migrationOptions;
	}
	
	public List<InfrastructureOption> getMigrationOptions() {
		return migrationOptions;
	}
	
	public void setMigrationOptions(List<InfrastructureOption> migrationOptions) {
		this.migrationOptions = migrationOptions;
	}
	
	//New Options
	public List<InfrastructureOption> getNewOptions() {
		return newOptions;
	}
	
	/**
	 * Add an Infrastructure option to the new Infrastructure options list
	 * 
	 * @param newOption the new option to add
	 * @return the updated reference
	 */
	public List<InfrastructureOption> addNewInfrastrutureOption(InfrastructureOption newOption) {
		newOptions.add(newOption);
		return newOptions;
	}
	
	public void setNewOptions(List<InfrastructureOption> newOptions) {
		this.newOptions = newOptions;
	}
	
	//Should only be called by the Builder
	private InfrastructureOptions(Builder builder) {
		this.currentVersion = builder.currentVersion;
		this.migrationOptions = builder.migrationOptions;
		this.newOptions = builder.newOptions;
		this.upgradeOptions = builder.upgradeOptions;
		
	}
	
	/**
	 * Used to build a reference for an InfrastructureOptions
	 * 
	 * @author Luke Shannon (Github: lshannon)
	 *
	 */
	public static class Builder {
		private InfrastructureOption currentVersion;
		private List<InfrastructureOption> upgradeOptions = new ArrayList<InfrastructureOption>();
		private List<InfrastructureOption> migrationOptions = new ArrayList<InfrastructureOption>();
		private List<InfrastructureOption> newOptions = new ArrayList<InfrastructureOption>();
		
		public Builder() {
		}
		
		public Builder setCurrentInfrastructure(InfrastructureOption currentVersion) {
			this.currentVersion = currentVersion;
			return this;
		}
		
		public Builder addNewOption(InfrastructureOption newOption) {
			this.newOptions.add(newOption);
			return this;
		}
		
		public Builder addUpgradeOption(InfrastructureOption updgradeOption) {
			this.upgradeOptions.add(updgradeOption);
			return this;
		}
		
		public Builder addMigrationOption(InfrastructureOption migrationOption) {
			this.migrationOptions.add(migrationOption);
			return this;
		}
		
		public InfrastructureOptions build() {
			return new InfrastructureOptions(this);
		}
	}
}