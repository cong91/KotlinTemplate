package vn.frghigh.template.data

import vn.frghigh.template.data.api.ApiHelper
import vn.frghigh.template.data.database.DatabaseHelper
import vn.frghigh.template.data.preferences.PreferencesHelper
import javax.inject.Inject

class DataManagerImpl @Inject constructor(
        private val databaseHelper: DatabaseHelper,
        private val preferencesHelper: PreferencesHelper,
        private val apiHelper: ApiHelper
) : DataManager {

}