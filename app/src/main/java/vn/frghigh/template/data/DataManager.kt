package vn.frghigh.template.data

import vn.frghigh.template.data.api.ApiHelper
import vn.frghigh.template.data.database.DatabaseHelper
import vn.frghigh.template.data.preferences.PreferencesHelper

/**
 * Repository class meant to be the only access point to all other data related classes
 */
interface DataManager: ApiHelper, DatabaseHelper, PreferencesHelper {
}