package de.ptb.dsi.dme_backend.service.input;

import de.ptb.dsi.dme_backend.model.*;
import org.w3c.dom.Document;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;

public class InputReaderService implements IInputReaderService {
    @Override
    public void loadData(ComparisonDataModel comparisonDataModel) {
        for (String contributionId : comparisonDataModel.getContributions().keySet()) {
            Contribution contribution = comparisonDataModel.getContributions().get(contributionId);
            Document contributionFile = readDocument(contribution.getPidInputData());
            for (EntityUnderComparison entity : comparisonDataModel.getEntities().values()) {
                for (String dataId : entity.getDataIdentifiers().keySet()) {
                    DataIdentifier dataIdentifier = entity.getDataIdentifiers().get(dataId);
                    SiReal siRealLoadedData = readData(dataIdentifier);
                    this.addDataToEntity(entity.getEntityData(), dataId, contributionId, siRealLoadedData);
                }
            }
        }
    }

    private Document readDocument(String pidInputData) {
        return null;
    }

    private SiReal readData(DataIdentifier dataIdentifier) {
        return null;
    }

    private void addDataToEntity(HashMap<String, ContributionEntityData> entityData, String identifierId, String contributionId, SiReal data) {
        ContributionEntityData contributionEntityData = entityData.get(identifierId);
        contributionEntityData.getContributionData().put(contributionId, data);
    }

}
