package com.geovote.data.intf;

import com.geovote.domain.context.election.Theme;

public interface ThemeDao {

	public Theme findElectionsThemeByCode(String code, String themeId);

}
